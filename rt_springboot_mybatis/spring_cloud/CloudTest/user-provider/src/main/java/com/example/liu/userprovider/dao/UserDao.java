package com.example.liu.userprovider.dao;

import com.example.liu.userprovider.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from tb_user where name=#{name} and password=#{password}")
    User login(@Param("name") String name, @Param("password") String password) ;

//    @Insert("insert into tb_user(name , password , regdatetime) values(#{name},#{password},now())")
//    int add(User user) ;
}
