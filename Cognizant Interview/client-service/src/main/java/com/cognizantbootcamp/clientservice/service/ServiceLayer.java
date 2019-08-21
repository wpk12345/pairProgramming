package com.cognizantbootcamp.clientservice.service;

import com.cognizantbootcamp.clientservice.dto.Person;
import com.cognizantbootcamp.clientservice.util.feign.PersonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

@Component
public class ServiceLayer {


    private PersonClient personClient;

    @Autowired
    public ServiceLayer(PersonClient personClient) {
        this.personClient = personClient;
    }

    public Person getPersonByName(String name) {
        Person person = new Person();
        person = personClient.getPersonByName(name);

        return person;
    }

//    @Transactional
//    public Person addPerson(Person person) {
//        person = personClient.createPerson(person);
//        return person;
//    }
}
