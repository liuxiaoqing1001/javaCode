package com.isoft.testmybatis.dao;

import com.isoft.testmybatis.entity.User2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface User2Dao {
    //@Select("select * from tb_user")
    @Select("SELECT id,name as uname ,password as upass,regdatetime,status,photourl,email,mobile,activecode " +
            "from tb_user")
    List<User2> getAll();

    @Select("select * from tb_user")

//    @Results({
//            @Result(id=true,column = "id" , property = "id") ,
//            @Result(column = "name" , property = "uname") ,
//            @Result(column = "password" , property = "upass") ,
//            @Result(column = "regdatetime" , property = "regdatetime") ,
//            @Result(column = "status" , property = "status") ,
//            @Result(column = "photourl" , property = "photourl") ,
//            @Result(column = "email" , property = "email") ,
//            @Result(column = "mobile" , property = "mobile") ,
//            @Result(column = "activecode" , property = "activecode")
//    })
    @ResultMap("com.isoft.testmybatis.result.UserMap")
    List<User2> getAll2();

    @Select("select * from tb_user where id=#{id}")
//    @Results({
//            @Result(id=true,column = "id" , property = "id") ,
//            @Result(column = "name" , property = "uname") ,
//            @Result(column = "password" , property = "upass") ,
//            @Result(column = "regdatetime" , property = "regdatetime") ,
//            @Result(column = "status" , property = "status") ,
//            @Result(column = "photourl" , property = "photourl") ,
//            @Result(column = "email" , property = "email") ,
//            @Result(column = "mobile" , property = "mobile") ,
//            @Result(column = "activecode" , property = "activecode")
//    })
    @ResultMap("com.isoft.testmybatis.result.UserMap")
    User2 getById(Integer id) ;
}
