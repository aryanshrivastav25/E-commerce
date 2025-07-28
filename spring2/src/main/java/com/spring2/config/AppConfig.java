package com.spring2.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Scope;
// import org.springframework.context.annotation.Primary;

// import com.spring2.Alien;
// import com.spring2.Computer;
// import com.spring2.Desktop;
// import com.spring2.Laptop;

@Configuration
@ComponentScan("com.spring2") // Automatically create beans for all the classes declared as @Component, this is called Stereotype annotation
public class AppConfig 
{    
    // // @Bean(name = {"com", "desk", "Desktop123"}) // Overrides the default bean name, can be recognized by multiple names
    // @Bean
    // @Primary
    // // @Scope(value="prototype") // Multiple objects can be created
    // public Desktop desktop() // By default, the bean name is the method name
    // {
    //     return new Desktop();
    // }

    // @Bean
    // public Laptop laptop()
    // {
    //     return new Laptop();
    // }

    // @Bean
    // // public Alien alien(@Autowired Computer com)
    // public Alien alien(@Qualifier("laptop") Computer com) // Autowiring for Dependency Injection, if there are multiple beans for Computer, @primary needs to be used or we can use @Qualifier("name") which selects a bean byName
    // // If both @Primary and @Qualifier are used, preference will be given to Qualifier
    // {
    //     Alien obj = new Alien();
    //     obj.setAge(25); // Setter injection
    //     obj.setLap(com);
    //     return obj;
    // }
}
