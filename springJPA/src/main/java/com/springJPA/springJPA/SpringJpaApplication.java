package com.springJPA.springJPA;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springJPA.springJPA.model.Student;
import com.springJPA.springJPA.repo.StudentRepo;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		StudentRepo repo = context.getBean(StudentRepo.class);

		s1.setRollNo(101);
		s1.setName("Aryan");
		s1.setMarks(60);

		s2.setRollNo(102);
		s2.setName("Ayush");
		s2.setMarks(70);

		s3.setRollNo(103);
		s3.setName("Aditya");
		s3.setMarks(80);

		// repo.save(s3);

		List<Student> l = repo.findAll();
		System.out.println(l);

		System.out.println(repo.findById(101)); // Returns an Optional<T> object which prevents null pointer
		// If object is null, we can use (repo.findById(101)).orElse(new Student());

		System.out.println(repo.findByName("Aryan"));

		System.out.println(repo.findByMarksGreaterThan(60));

		repo.save(s1); // It can both update and insert data
		// Save method first file the select query to check if the row exist. if exist, it inserts otherwise it updates.
		repo.delete(s2); // First check using select if it exist, then delete the row if it exist
	}

}
