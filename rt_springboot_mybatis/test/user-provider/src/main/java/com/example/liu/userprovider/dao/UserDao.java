package com.example.liu.userprovider.dao;

//import com.example.liu.common.entity.User;
import com.example.liu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from tb_user where name=#{username} and password=#{password}")
    User login(@Param("username") String name , @Param("password") String pass) ;

    @Insert("insert into tb_user(name,password,regdatetime,status,activecode) values(#{name},#{password},now(),0,#{activecode})")
    int add(User user) ;
}
