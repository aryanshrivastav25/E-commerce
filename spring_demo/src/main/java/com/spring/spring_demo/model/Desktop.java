package com.spring.spring_demo.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{
    Desktop()
    {
        
    }
    public void compile()
    {
        System.out.println("Compiling in Desktop");
    }
}
