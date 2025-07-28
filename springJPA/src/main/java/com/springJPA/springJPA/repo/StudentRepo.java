package com.springJPA.springJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springJPA.springJPA.model.Student;
import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> // JpaRepository accepts two parameters, the data type whose table we want to create, and data type of the primary key column
{
    @Query("select s from Student s where s.name = ?1") // Query uses JPQL, Student is the class name, not the table name.
    // s.name = ?1 => It specifies which parameter of the function will take up the question mark placeholder.
    // If we have multiple parameters and ?, then ?1, ?2, ?3 can be used to differentiate each parameter
    public List<Student> findByName(String name);
    public List<Student> findByMarksGreaterThan(int marks);
}

// @Query allows us to create custom findBy methods.
// By default, methods like getByName, getByMarks, getByMarksGreaterThan, where name and marks are column names in class, they already exist by default and we dont need Query annotation but we need to declare those methods.
// JPA already creates these methods behind the scene.