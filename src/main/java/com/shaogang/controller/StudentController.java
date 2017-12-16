package com.shaogang.controller;

import com.shaogang.bean.Student;
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

    @RequestMapping("/list")
    public List<Student> getStudents() {
        logger.info("从数据库读取Student集合");
        return studentService.getList();
    }
}
