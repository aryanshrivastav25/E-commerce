package com.springJDBC.springJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springJDBC.springJDBC.model.Student;
import com.springJDBC.springJDBC.repo.StudentRepo;

@Service
public class StudentService {

    StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s)
    {
        repo.save(s);
    }

    public List<Student> getStudents()
    {
        return repo.findAll();
    }
}
