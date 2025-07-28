package com.springJDBC.springJDBC.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springJDBC.springJDBC.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;
    public JdbcTemplate getTemplate() 
    {
        return jdbc;
    }

    @Autowired
    public void setTemplate(JdbcTemplate jdbc) 
    {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into Student (`rollNo`, `name`, `marks`) values (?,?,?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println("Saved: " + rows + " rows affected");
    }

    public List<Student> findAll() {
        String sql = "select * from Student";

        // It is a functional interface, whose function returns the object extracted from ResultSet
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student s = new Student();
            s.setMarks(rs.getInt("marks"));
            s.setRollNo(rs.getInt("rollNo"));
            s.setName(rs.getString("name"));
            return s;
        };

        // Returns the list of objects returned by mapper(RowMapper<Student>), mapper at one time returns one object. query function returns a list of Student object each row extracted from ResultSet parameter of RowMapper
        return jdbc.query(sql, mapper);
    }
    
}
