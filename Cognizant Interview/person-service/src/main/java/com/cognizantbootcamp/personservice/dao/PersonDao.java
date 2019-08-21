package com.cognizantbootcamp.personservice.dao;

import com.cognizantbootcamp.personservice.dto.Person;

import java.util.List;

public interface PersonDao {

    Person addPerson(Person person);

    Person getPerson(int id);

    List<Person> getAllPersons();

    void updatePerson(Person person);

    void deletePerson(int id);

    Person findPersonByName(String name);


}
