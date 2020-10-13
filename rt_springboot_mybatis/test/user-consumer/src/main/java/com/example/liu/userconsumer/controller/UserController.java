package com.example.liu.userconsumer.controller;

import com.example.liu.bean.ResponseData;
import com.example.liu.entity.User;
import com.example.liu.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;

    @GetMapping("/{name}/{pwd}")
    public ResponseData login(@PathVariable("name") String name , @PathVariable("pwd") String password) {
        int errCode = 0 ;
        String msg = "" ;
        User u = null ;
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            errCode = 1 ;
            msg = "账号或者密码不能为空!" ;
        } else {
            u = userService.login(name , DigestUtils.md5DigestAsHex(password.getBytes())) ;

        }
        return new ResponseData(errCode , msg , u) ;
    }

    @PostMapping
    public ResponseData add(User u) {
        int r = 0 ;
        if(null == u || StringUtils.isEmpty(u.getName()) || StringUtils.isEmpty(u.getPassword()) ) {
            r = 1 ;
        } else {
            u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
            r = userService.add(u);
        }
        return new ResponseData(
                r > 0 ? 0 : 1 ,
                r > 0 ? "注册成功" : "注册失败" ,
                r > 0
        ) ;
    }
}

