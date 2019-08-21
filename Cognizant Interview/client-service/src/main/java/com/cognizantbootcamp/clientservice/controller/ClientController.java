package com.cognizantbootcamp.clientservice.controller;

import com.cognizantbootcamp.clientservice.dto.Person;
import com.cognizantbootcamp.clientservice.service.ServiceLayer;
import com.cognizantbootcamp.clientservice.util.feign.PersonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class ClientController {

//    ServiceLayer service;


    @Autowired
    private PersonClient client;


    public ClientController(PersonClient client) {
        this.client = client;
    }

    @RequestMapping(value = "/clientfe/person/{name}", method = RequestMethod.GET)
    public Person getPersonByName(@PathVariable String name) {
        return client.getPersonByName(name);
    }

    @RequestMapping(value = "/clientfe/addperson", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return client.createPerson(person);
    }

}
