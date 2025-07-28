package com.spring.spring_demo.repo;

import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save()
    {
        System.out.println("Saved in Database");
    }
}
