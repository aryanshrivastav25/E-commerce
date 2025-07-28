package com.hib;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Student s1 = new Student();
        s1.setName("Aryan");
        s1.setRollNo(62);
        s1.setAge(19);
        
        // // Configure Hibernate
        // Configuration cnfg = new Configuration();
        // // Add the entity class to hibernate
        // cnfg.addAnnotatedClass(com.hib.Student.class); // (package name).(class name).class
        // cnfg.configure();

        // // Create a session for database
        // SessionFactory sf = cnfg.buildSessionFactory();
        // Session session = sf.openSession();

        Session session = new Configuration() // Creating a configuration object
            .addAnnotatedClass(com.hib.Student.class) // Adding the annotated class to the configuration(Entity)
            .configure() // Configuring the configuration object
            .buildSessionFactory() // Building the session factory
            .openSession(); // Opening a session

        // Transaction control for commiting the transaction
        Transaction transaction = null;
        // Save the data to the Student table
        try
        {
            transaction = session.beginTransaction();
            session.persist(s1);
            transaction.commit();
            System.out.println(s1);
        }
        catch(ConstraintViolationException e)
        {
            System.out.println("Primary key already exist " + e.getMessage());
            if (transaction != null)
                transaction.rollback();
        }



        // Fetching the data
        Student s2 = session.get(Student.class, 61);
        System.out.println(s2);

        // Update the data
        Student s3 = new Student(63, "Abhishek", 21);

        transaction = session.beginTransaction();
        session.merge(s3); // Update the data with given primary key if it exist otherwise insert to the table
        transaction.commit();
        System.out.println(s3);

        Student s4 = session.get(Student.class, 63);
        transaction = session.beginTransaction();
        session.remove(s4); // Delete the data with given primary key
        transaction.commit();
        System.out.println(s4);

        session.close();

        /*  When you are inserting, removing or updating a row, always first fetch it by the session.get() method
            This is because the session.get() method will return the object which is already in the session cache.
            If you are inserting, removing or deleting a row without first fetching it, then it will be treated as a new object.
            Then the new object is loaded into the session cache and if the row with same primary key already exist in the session cache, it raises an error
        */


        session = new Configuration()
                .addAnnotatedClass(com.hib.Alien.class)
                .addAnnotatedClass(com.hib.Laptop.class)
                .configure()
                .buildSessionFactory()
                .openSession();

        Laptop l1 = new Laptop(5, "Jaxon", "Macbook Pro", 16);
        Laptop l2 = new Laptop(6, "Chrome", "XPS", 8);
        Alien a1 = new Alien();
        a1.setAid(103);
        a1.setAname("Ayush");
        a1.setAtech("Java");
        a1.setLaptops(Arrays.asList(l1, l2));
        l1.setAlien(a1);
        l2.setAlien(a1);

        // transaction = null;

        // try
        // {
        //     transaction = session.beginTransaction();
        //     session.persist(a1);
        //     transaction.commit();
        //     transaction = null;
        //     System.err.println(a1);
        // }
        // catch(Exception e)
        // {
        //     System.out.println(e.getMessage());
        // }


        // Alien a2 = session.get(Alien.class, 1);
        // System.out.println(a2);

        transaction = session.beginTransaction();
        session.persist(a1);
        session.persist(l1);
        session.persist(l2);
        transaction.commit();

        session.close();
     }
}
