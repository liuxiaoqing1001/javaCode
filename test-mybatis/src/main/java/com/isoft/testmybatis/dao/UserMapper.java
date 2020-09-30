package com.isoft.testmybatis.dao;

import com.isoft.testmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getByNameKey(String nameKey) ;

    int delById(Integer id) ;
}
