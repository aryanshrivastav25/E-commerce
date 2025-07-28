package com.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// import java.beans.ConstructorProperties;

@Component // Declare the class as a bean when using Stereotype annotations(ComponentScan)
// by default, Bean name is the name of the class in lowercase
public class Alien 
{
    @Value("21")
    int age;
    @Autowired // Automatically connects the computer class to the Alien class, if multiple beans of Computer are found, Qualifier or Primary needs to be used
    @Qualifier("lap")
    // Field injection
    Computer lap;


    @Autowired // Constructor injection
    Alien(Computer lap)
    {
        System.out.println("Paramterized constructor called");
        this.lap = lap;
    }

    // @ConstructorProperties({"age", "lap"}) // For the constructor-arg tag and its name attribute, if we use name attribute instead of index then the sequencing matters but if we use this constructorPropertioes() by giving the name to each parameter, then sequencing in xml file does not matter and it will match the parameter by the name
    // Alien(int age, Computer lap)
    // {
    //     System.out.println("Paramterized constructor called");
    //     this.age = age;
    //     this.lap = lap;
    // }

    public Computer getLap() {
        return lap;
    }
    @Autowired // Setter injection
    public void setLap(Computer lap) {
        System.out.println("Alien setter called");
        this.lap = lap;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    public Alien()
    {
        System.out.println("Alien is created");
    }
    public void code()
    {
        System.out.println("Coding...");
        lap.compile();
    }
}
