package com.coursestopics.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldController {

//    @RequestMapping({ "/" })
//    public String firstPage() {
//        return "Hello World";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "https://id.heroku.com/oauth/authorize?client_id={course}&response_type=code&scope={scopes}&state={aff5f91d-420d-4d91-827e-73ee584607ed}");
        httpServletResponse.setStatus(302);
    }
}