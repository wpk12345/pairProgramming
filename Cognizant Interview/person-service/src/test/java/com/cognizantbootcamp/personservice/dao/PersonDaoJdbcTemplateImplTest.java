package com.cognizantbootcamp.personservice.dao;

import com.cognizantbootcamp.personservice.dto.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonDaoJdbcTemplateImplTest {

    @Autowired
    PersonDao personDao;

    @Before
    public void setUp() throws Exception {

        // clear DB list before testing
        List<Person> people = personDao.getAllPersons();
        for (Person p : people) {
            personDao.deletePerson(p.getId());

        }
    }

    @Test
    public void addGetDeletePerson() {

        //ADD person
        Person person = new Person();
        person.setName("Name");
        person.setAge(30);

        person = personDao.addPerson(person);

        //GET person
        Person person1 = personDao.getPerson(person.getId());
        assertEquals(person1, person);

        //DELETE
        personDao.deletePerson(person.getId());
        person1 = personDao.getPerson(person.getId());
        assertNull(person1);

    }

    @Test
    public void getAllPersons() {

        //ADD one
        Person person = new Person();
        person.setName("Name");
        person.setAge(30);

        person = personDao.addPerson(person);

        //ADD two
        Person person2 = new Person();
        person2.setName("Name two");
        person2.setAge(35);

        person2 = personDao.addPerson(person2);

        //GET all people
        List<Person> people = personDao.getAllPersons();
        assertEquals(2, people.size());

    }

    @Test
    public void updatePerson() {

        //ADD person
        Person person = new Person();
        person.setName("Name");
        person.setAge(30);

        person = personDao.addPerson(person);

        //update to person
        person.setName("Update Name");

        personDao.updatePerson(person);

        Person person1 = personDao.getPerson(person.getId());
        assertEquals(person1, person);

    }

    @Test
    public void findPersonByName() {

        Person person = new Person();
        person.setName("Name");
        person.setAge(30);

        person = personDao.addPerson(person);

        Person person1 = new Person();
        person1.setName("Name One");
        person1.setAge(35);

        person1 = personDao.addPerson(person1);

        Person person2 = new Person();
        person2.setName("Name Two");
        person2.setAge(40);

        person2 = personDao.addPerson(person2);

        Person testPerson = personDao.findPersonByName(person.getName());
        assertEquals(testPerson, person);
    }
}