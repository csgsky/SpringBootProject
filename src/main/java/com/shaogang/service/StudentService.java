package com.shaogang.service;

import com.shaogang.bean.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
            stu.setName(rs.getString("NAME"));
            stu.setAge(rs.getString("AGE"));
            stu.setGender(rs.getString("GENDER"));
            return stu;
        });
    }

    // 获取当前数据库最后一条数据的 id
    public int[] getLastUserId() {
        final int[] id = {0};
        String sql = "SELECT * FROM Marels.user order by id DESC limit 1";
        jdbcTemplate.query(sql, set -> {
            id[0] = set.getInt("ID");
        });
        return id;
    }

    public int insertUser(Student student) {
        int id = student.getId();
        String name = student.getName();
        String age = student.getAge();
        String gender = student.getGender();
        try {
            int update = jdbcTemplate.update("INSERT INTO Marels.user(NAME, AGE, GENDER) VALUES (?, ?, ?)", name, age, gender);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int DeleteUser (int id) {
        String sql = "delete from Marels.user where id = ? ";
        try {
            int update = jdbcTemplate.update(sql, id);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
