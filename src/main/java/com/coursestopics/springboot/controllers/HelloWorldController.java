package com.coursestopics.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldController {

    @RequestMapping({ "/" })
    public String firstPage() {
        return "Hello u beautiFULL ppl!";
    }
}