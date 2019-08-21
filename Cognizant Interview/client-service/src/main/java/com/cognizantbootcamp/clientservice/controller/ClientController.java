package com.cognizantbootcamp.clientservice.controller;

import com.cognizantbootcamp.clientservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    ServiceLayer service;

    @Autowired ClientController(ServiceLayer service){
        this.service = service;
    }


}
