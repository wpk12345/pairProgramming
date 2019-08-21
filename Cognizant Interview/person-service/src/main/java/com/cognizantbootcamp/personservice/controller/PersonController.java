package com.cognizantbootcamp.personservice.controller;

import com.cognizantbootcamp.personservice.dao.PersonDao;
import com.cognizantbootcamp.personservice.dto.Person;
import com.cognizantbootcamp.personservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonDao dao;

    @PostMapping("/addperson")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody @Valid Person person) {
       return dao.addPerson(person);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson(@PathVariable("id") int id) {
        Person person = dao.getPerson(id);
        if (person == null) {
            throw new NotFoundException("Person could not be retrieved by ID: " + id);
        }
        return person;
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonByName(@PathVariable("name") String name) {
        Person person = dao.findPersonByName(name);
        if (person == null) {
            throw new NotFoundException("Person could not be retrieved by name: " + name);
        }
        return person;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Person> getAllPeople() {
        return dao.getAllPersons();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("id") int id) {
        dao.deletePerson(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable("id") int id, @RequestBody @Valid Person person) {
        if (person.getId() == 0) {
            person.setId(id);

        if (id != person.getId())
            throw new IllegalArgumentException("ID on path must match ID in Person object");
        }
        dao.updatePerson(person);

    }



}
