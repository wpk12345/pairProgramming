package com.cognizantbootcamp.clientservice.service;

import com.cognizantbootcamp.clientservice.dto.Person;
import com.cognizantbootcamp.clientservice.util.feign.PersonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    private PersonClient personClient;

    @Autowired
    public ServiceLayer(PersonClient personClient) {
        this.personClient = personClient;
    }

    public Person getPersonByName()
}
