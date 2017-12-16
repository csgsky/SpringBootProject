package com.shaogang.service;

import com.shaogang.bean.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by allen on 17/12/5.
 */
@Service
public class StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getList(){
        String sql = "SELECT * FROM Marels.user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student stu = new Student();
            stu.setId(rs.getInt("ID"));
            stu.setAge(rs.getString("AGE"));
            stu.setGender(rs.getString("GENDER"));
            return stu;
        });
    }
}
