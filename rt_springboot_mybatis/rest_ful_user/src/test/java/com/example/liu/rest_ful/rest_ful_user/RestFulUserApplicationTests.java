package com.example.liu.rest_ful.rest_ful_user;

import com.example.liu.rest_ful.rest_ful_user.entity.User;
import com.example.liu.rest_ful.rest_ful_user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestFulUserApplicationTests {

    //测试：dao层/后端    /test/java/.../RestFulUserApplicationTests
    //postman测试controller到service到dao层
    //  运行发布RestFulUserApplication  对照UserController测试
    //  Get  http://localhost:8090/user/{name}/{password}
    //  POST http://localhost:8090/user
    //      postman中选择post方式-body-选中raw-选择json格式-填写如下发送
    //      {"name":"mulan","password":"123"}
    //  PUT http://localhost:8090/user
    //      postman：params或body中form-data/x-www-form-urlencoded
    //      {id:1,password:"123"} 或者 {id:1,mobile:"12345676453"}
    //上传头像
    //  POST http://localhost:8090/user/photo
    //      postman：form-data/x-www-form-urlencoded
    //      {id:10,userphoto:url}

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
//        //测试登陆
//        System.out.println(userService.loginCheck("aa","123"));//{Msg=1}账号不存在
//        System.out.println(userService.loginCheck("张三","123456"));//{Msg=2}密码错误
//        System.out.println(userService.loginCheck("rose","123"));//{Msg=0, 返回User对象}

//        //测试注册
//        System.out.println(userService.register(null));
//        User u1 = new User() ;
//        u1.setName("aaa");
//        System.out.println(userService.register(u1));//2 2 信息不完整，注册失败
//        u1.setName("rose");
//        u1.setPassword("123");
//        System.out.println(userService.register(u1));//1 账号已存在
//        u1.setName("aaa");
//        System.out.println(userService.register(u1));//0 成功

        //修改更新
        User u2 = new User() ;
        System.out.println(userService.update(u2));//null 信息不完整
        u2.setId(10);
        System.out.println(userService.update(u2));//null
        u2.setMobile("1387654321");
        System.out.println(userService.update(u2));//修改电话，返回User对象
        u2.setMobile(null);
        u2.setPassword("321");
        System.out.println(userService.update(u2));//修改密码
        u2.setPassword(null);
        u2.setStatus(1);
        System.out.println(userService.update(u2));//修改状态
        u2.setStatus(null);
        u2.setPhotourl("hhhhhh");
        System.out.println(userService.update(u2));//修改头像
        //修改电子邮件：在dao层和service都要写
    }

}
