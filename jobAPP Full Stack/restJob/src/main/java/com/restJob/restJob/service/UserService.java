package com.restJob.restJob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.restJob.restJob.model.User;
import com.restJob.restJob.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers()
    {
        return repo.findAll();
    }

    public User getUser(Integer id)
    {
        return repo.findById(id).orElse(new User());
    }

    public User addUser(User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User updateUser(User user)
    {
        return repo.save(user);
    }

    public void deleteUser(Integer id)
    {
        repo.deleteById(id);
    }

    public boolean authenticateUser(String username, String password)
    {
        User user = repo.findByUsername(username);
        if (user == null)
            return false;
        if (!user.getUsername().equals(username))
            throw new UsernameNotFoundException("Username not found");
        if (!bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            throw new BadCredentialsException("Password incorrect");
        }

        return true;
    }
}
