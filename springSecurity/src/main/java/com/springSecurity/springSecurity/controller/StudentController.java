package com.springSecurity.springSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurity.springSecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Aryan", "C"),
        new Student(2, "Ayush", "C++"),
        new Student(3, "Aditya", "Java")
    ));

    
    @GetMapping("/csrf-token")
    public CsrfToken getcsrf(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @GetMapping("/student")
    public List<Student> getAllStudent()
    {
        return students;
    }

    @PostMapping("/student")
    public Student postMethodName(@RequestBody Student s) {
        students.add(s);
        return s;
    }
    
}
