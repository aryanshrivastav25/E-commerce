package com.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring2.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = (Desktop) context.getBean(Desktop.class);
        // Desktop dt = context.getBean("desktop", Desktop.class);
        // Desktop dt = context.getBean(Desktop.class);

        Desktop dt2 = context.getBean(Desktop.class);
        dt2.compile();

        Alien obj = context.getBean(Alien.class); // Configured in xml file in reources folder
        obj.code();




        // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // System.out.println("Context created");
        // Alien obj = context.getBean("alien", Alien.class); // Configured in xml file in reources folder
        // obj.code();
        // Computer obj3 = context.getBean(Computer.class); // It will search by the type of object in xml file, it there is only matching object it will give that otherwise we need to set the primary attribute

        // Alien obj2 = (Alien) context.getBean("alien"); // Configured in xml file in reources folder
        // obj2.code();

        // // The alien object is created at the time when ApplicationContext is created, not when we use the getBean()
        // // Constructor is called when we add the bean in xml file, and create the ApplicationContext Object
        // // Not when we use the getBean()
        // // If we add a new bean in xml file multiple times using different id in <bean id="">, then Constructor will be called multiple times

        // /*
        //  * This is because of scope. By default, in xml file, only a single object is created for entire project.
        //  * This scope is called singleton.
        //  * To create new objects each time the getBean() is called, change the scope to scope="protoype" in xml file
        //  */
        // Laptop o = (Laptop) context.getBean("lap"); // If laptop is an inner bean it cannot be accessed from outside
        //  System.out.println(obj.getAge());
    }
}
