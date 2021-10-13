package com.coursestopics.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping({ "/" })
    public String firstPage() {
        return "Hello World";
    }

}