package com.example.liu.springboot_mybatis2.dao;

import com.example.liu.springboot_mybatis2.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

//    在xml中描述dao层接口的方法实现方式
//      1）xml文件中，mapper的namespace属性是接口的签名
//    ​	2）xml中每一个描述sql语句的元素的id值是接口中方法的名字
//    ​	3）select查询必须描述resultType或者resuleMap
//    ​	4）xml文件必须在mybatis的全局配置文件或者application全局配置文件中声明

//    在UserMapper.xml中实现
    List<User> getByNameKey(String nameKey);

    int delById(Integer id) ;
}
