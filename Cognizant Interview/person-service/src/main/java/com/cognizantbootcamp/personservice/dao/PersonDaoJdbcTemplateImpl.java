package com.cognizantbootcamp.personservice.dao;


import com.cognizantbootcamp.personservice.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDaoJdbcTemplateImpl implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared SQL Statements

    private static final String INSERT_PERSON_SQL =
            "insert into person (name, age) values (?, ?)";
    private static final String SELECT_PERSON_SQL =
            "select * from person where id = ?";
    private static final String DELETE_PERSON_SQL =
            "delete from person where id = ?";
    private static final String SELECT_ALL_PEOPLE_SQL =
            "select * from person";
    private static final String UPDATE_PERSON_SQL =
            "update person set name = ?, age = ? where id = ?";
    private static final String SELECT_PERSON_BY_NAME_SQL =
            "select * from person where name = ?";


    @Override
    @Transactional
    public Person addPerson(Person person) {
        jdbcTemplate.update(INSERT_PERSON_SQL,
                person.getName(),
                person.getAge());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        person.setId(id);

        return person;
    }

    @Override
    public Person getPerson(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_PERSON_SQL, this::mapRowToPerson, id);
        } catch (EmptyResultDataAccessException e) {
            return null;

        }
    }

    @Override
    public List<Person> getAllPersons() {

        return jdbcTemplate.query(SELECT_ALL_PEOPLE_SQL, this::mapRowToPerson);
    }

    @Override
    public void updatePerson(Person person) {

        jdbcTemplate.update(UPDATE_PERSON_SQL,
                person.getName(),
                person.getAge(),
                person.getId());
    }

    @Override
    public void deletePerson(int id) {
        jdbcTemplate.update(DELETE_PERSON_SQL, id);
    }

    @Override
    public Person findPersonByName(String name) {

        try {
            return jdbcTemplate.queryForObject(SELECT_PERSON_BY_NAME_SQL, this::mapRowToPerson, name);
        } catch (EmptyResultDataAccessException e) {
            throw new NullPointerException("Person name does not exist.");
        }
    }

private Person mapRowToPerson (ResultSet rs, int rowNum) throws SQLException {
    Person person = new Person();
    person.setId(rs.getInt("id"));
    person.setName(rs.getString("name"));
    person.setAge(rs.getInt("age"));

    return person;
}
}
