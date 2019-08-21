package com.cognizantbootcamp.personservice.controller;

import com.cognizantbootcamp.personservice.dao.PersonDao;
import com.cognizantbootcamp.personservice.dto.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    PersonDao dao;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addPerson() throws Exception {

        Person person = new Person();
        person.setName("Name");
        person.setAge(30);

        String inputJson = mapper.writeValueAsString(person);

        Person output = new Person();
        output.setId(1);
        output.setName("Name");
        output.setAge(30);

        when(dao.addPerson(person)).thenReturn(output);

        mockMvc.perform(post("/person/addperson").content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(output)));
    }

    @Test
    public void getAll() throws Exception {

        Person person = new Person();
        
    }



}
