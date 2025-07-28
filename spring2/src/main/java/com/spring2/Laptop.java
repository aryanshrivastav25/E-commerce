package com.spring2;

import org.springframework.stereotype.Component;

@Component("lap")
// @Scope("prototype")
public class Laptop implements Computer 
{
    public Laptop()
    {
        System.out.println("In Laptop");
    }

    @Override
    public void compile()
    {
        System.out.println("Compiling...");
    }    
}
