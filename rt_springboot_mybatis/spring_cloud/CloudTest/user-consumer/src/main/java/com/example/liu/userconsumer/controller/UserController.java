package com.example.liu.userconsumer.controller;

import com.example.liu.userconsumer.bean.ResponseData;
import com.example.liu.userconsumer.entity.User;
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
    public ResponseData login(@PathVariable("name") String name , @PathVariable("pwd") String pass) {
        int errCode = 0 ;
        String msg = "" ;
        User u = null ;
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pass)) {
            errCode = 1 ;
            msg = "账号或者密码不能为空!" ;
        } else {
            u = userService.login(name , pass) ;
            if (u==null) {
                errCode = 2 ;
                msg = "账号或者密码错误!" ;
            }else {
                if(u.getId()==400){
                    msg="error";
                }else {
                    msg = "登陆成功" ;
                }
            }
        }
        return new ResponseData(errCode , msg , u) ;
    }

//    @GetMapping("/add")
//    public ResponseData register(User user) {
//        boolean r = userService.register(user) ;
//        return new ResponseData(
//                r ? 0 : 400 ,
//                r ? "注册成功" : "注册失败" ,
//                r
//        ) ;
//    }
}
