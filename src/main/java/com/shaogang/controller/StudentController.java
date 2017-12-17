package com.shaogang.controller;

import com.shaogang.bean.Student;
import com.shaogang.bean.User;
import com.shaogang.domain.UserRepository;
import com.shaogang.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by allen on 17/12/5.
 */
@RestController
@RequestMapping("/stu")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserRepository mUserRepository;

    @RequestMapping("/list")
    public List<Student> getStudents() {
        logger.info("从数据库读取Student集合");
        return studentService.getList();
    }

    @RequestMapping("/insert")
    public void insertStu() {
        int lastId = studentService.getLastUserId()[0] + 1;
        User user = new User();
        user.setName("chenss" + lastId);
        user.setAge("25");
        user.setGender("female");
        mUserRepository.save(user);
    }

    @RequestMapping("/delete")
    public int updateStu() {
        int lastId = studentService.getLastUserId()[0];
        return studentService.DeleteUser(lastId);
    }

    @RequestMapping("/findbyname")
    public String findByName() {
        User shao = mUserRepository.findByName("shao");
        return shao.getAge();
    }

}
