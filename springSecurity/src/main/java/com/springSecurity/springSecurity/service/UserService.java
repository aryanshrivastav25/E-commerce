package com.springSecurity.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springSecurity.springSecurity.model.User;
import com.springSecurity.springSecurity.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    @Autowired
    private BCryptPasswordEncoder encoder; // Configured a spring managed bean in SecurityConfig.java

    public User registerUser(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }
}
