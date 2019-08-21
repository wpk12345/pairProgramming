package com.cognizantbootcamp.clientservice.controller;

import com.cognizantbootcamp.clientservice.dto.Person;
import com.cognizantbootcamp.clientservice.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @MockBean
    ServiceLayer service;

    @Autowired
    private MockMvc mvc;

    private ObjectMapper mapper = new ObjectMapper();

    private String clientJson;

    @Before
    public void setUp() throws Exception {
        Person person = new Person();
        person.setId(1);

        clientJson = mapper.writeValueAsString(person);

        Mockito.when(service.)
    }
}
