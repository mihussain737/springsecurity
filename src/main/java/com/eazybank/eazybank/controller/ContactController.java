package com.eazybank.eazybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contacts")
    public String getContact(){
        return "contact";
    }
}
