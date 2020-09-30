package com.example.liu.springboot_mybatis.service;

import com.example.liu.springboot_mybatis.dao.CourseDao;
import com.example.liu.springboot_mybatis.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseDao cDao;

    public List<Course> getAll() {
        return cDao.getAll() ;
    }
}
