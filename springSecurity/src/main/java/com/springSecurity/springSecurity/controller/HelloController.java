package com.springSecurity.springSecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request)
    {
        return "Hello " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest reqest) {
        return "This is Spring Security " + reqest.getSession().getId();
    }
    
}
