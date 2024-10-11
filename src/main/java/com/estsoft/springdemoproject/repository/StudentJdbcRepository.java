package com.estsoft.springdemoproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StudentJdbcRepository")
public class StudentJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> selectStudentNameList() {
        jdbcTemplate.queryForList("select name from student", String.class);
        return List.of();
    }

    public List<String> selectStudentInstructorList() {
        jdbcTemplate.queryForList("select name from instructor", String.class);
        return List.of();
    }

}
