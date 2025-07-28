package com.restJob.restJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.restJob.restJob.model.User;
import com.restJob.restJob.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.err.println("Regitration successful");
        userService.addUser(user);
        return new ResponseEntity<>("User registered", HttpStatus.OK);
    }
}
