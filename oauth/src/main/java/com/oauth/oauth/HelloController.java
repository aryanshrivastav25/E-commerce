package com.oauth.oauth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloString() {
        return "Hello, world";
    }
    
}
