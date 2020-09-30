package com.example.liu.springboot_mybatis.controller;

import com.example.liu.springboot_mybatis.entity.Course;
import com.example.liu.springboot_mybatis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService ;

    @GetMapping("/course/all")
    public List<Course> getAll() {
        return courseService.getAll() ;
    }
}
