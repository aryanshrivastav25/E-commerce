package com.spring.spring_demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.spring_demo.repo.LaptopRepository;
import com.spring.spring_demo.model.Laptop;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap)
    {
        repo.save();
    }

    boolean isGoodForProgramming(Laptop Lap)
    {
        return true;
    }
}
