package com.example.liu.springboot_mybatis2.dao;

import com.example.liu.springboot_mybatis2.entity.User;
import com.example.liu.springboot_mybatis2.entity.User2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface User2Dao {

////    结果uname,upass与数据库的不匹配
//    @Select("select * from tb_user")
//    List<User2> getAll();

//    解决方法1
//      通过使用别名
    @Select("SELECT id,name as uname ,password as upass,regdatetime,status,photourl,email,mobile,activecode " +
            "from tb_user")
    List<User2> getAll();

//    解决方法2
//        使用@Results注解或者\<resultMap>来说明查询结果和成员的对应关系
    @Select("select * from tb_user")
////    1
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
//    2
    @ResultMap("com.example.liu.springboot_mybatis2.result.UserMap")
    List<User2> getAll2();

//    @Results不能重复使用，只能再重述一遍
//    要想重复用，使用 <resultMap>
/*
<resultMap>
①。创建xml文件    resources/com/example/liu/springboot_mybatis2/mapper/result.xml
②。application.properties中添加配置项
③。使用@ResultMap注解
   @ResultMap("com.example.liu.springboot_mybatis.result.UserMap")
*/

//    1
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
//    2
    @ResultMap("com.example.liu.springboot_mybatis2.result.UserMap")
    User2 getById(Integer id) ;
}