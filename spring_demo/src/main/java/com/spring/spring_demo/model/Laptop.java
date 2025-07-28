package com.spring.spring_demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Laptop implements Computer{
    Laptop()
    {
        
    }

    public void compile()
    {
        System.out.println("Compiling in Laptop");
    }
}
