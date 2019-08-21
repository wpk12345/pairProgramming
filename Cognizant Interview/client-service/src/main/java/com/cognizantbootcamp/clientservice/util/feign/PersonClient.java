package com.cognizantbootcamp.clientservice.util.feign;

import com.cognizantbootcamp.clientservice.dto.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "person-service")
public interface PersonClient {

    @RequestMapping(value = "/person/addperson", method = RequestMethod.POST)
    Person createPerson(@RequestBody Person person);

    @RequestMapping(value = "/person/{name}", method = RequestMethod.GET)
    Person getPersonByName(@PathVariable("name")String name);

}

