package com.hib;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Follow the JPA standards

@Entity //(name="student_table") // Annotation for a class for which there is a table
public class Student {
    private String name;

    @Id // Primary key, must have
    @Column
    private int rollNo;

    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", age=" + age + "]";
    }

    public Student()
    {

    }

    public Student(int rollNo, String name, int age) 
    {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }
}
