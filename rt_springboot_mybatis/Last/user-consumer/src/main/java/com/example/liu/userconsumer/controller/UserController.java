package com.example.liu.userconsumer.controller;

import com.example.liu.userconsumer.bean.ResponseData;
import com.example.liu.userconsumer.entity.User;
import com.example.liu.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;
    @GetMapping("/{name}/{pwd}")
    public ResponseData login(@PathVariable("name") String name , @PathVariable("pwd") String pass) {
        User u = userService.login(name , pass) ;
        return new ResponseData(
                u != null ? 0 : 1 ,
                u != null ? "登录成功" : "登录失败",
                u
        ) ;
    }

    @GetMapping("/add")
    public ResponseData register(User user) {
        boolean r = userService.register(user) ;
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "注册成功" : "注册失败" ,
                r
        ) ;
    }
}
