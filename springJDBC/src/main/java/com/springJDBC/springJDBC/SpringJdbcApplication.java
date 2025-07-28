package com.springJDBC.springJDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springJDBC.springJDBC.model.Student;
import com.springJDBC.springJDBC.service.StudentService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student s = context.getBean(Student.class);

		s.setMarks(70);
		s.setName("Aditya");
		s.setRollNo(105);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s); 

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
