package com.example.liu.springboot_mybatis.dao;

import com.example.liu.springboot_mybatis.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseDao {
    /**
     * 获取所有课程信息
     */
    @Select("select * from c3.tb_course")
    List<Course> getAll() ;
}
