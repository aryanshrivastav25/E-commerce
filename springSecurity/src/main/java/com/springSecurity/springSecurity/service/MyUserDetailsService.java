package com.springSecurity.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springSecurity.springSecurity.model.User;
import com.springSecurity.springSecurity.model.UserPrincipal;
import com.springSecurity.springSecurity.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repo.findByUsername(username);
        if (user == null)
        {
            System.out.println("Username not found");
            throw new UsernameNotFoundException("Error 404");
        }

        return new UserPrincipal(user);
    }
     
}
