package com.example.liu.rest_ful.rest_ful_user.controller;

import com.example.liu.rest_ful.rest_ful_user.bean.ResponseData;
import com.example.liu.rest_ful.rest_ful_user.entity.User;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    //  Get  http://localhost:8090/user/{name}/{pwd}
    @GetMapping("{name}/{pwd}")
    public ResponseData login(@PathVariable("name") String name , @PathVariable("password") String password) {
        // 调用service中方法进行login处理
        User u = new User() ;
        u.setId(1) ;u.setName(name); u.setPassword(DigestUtils.md5DigestAsHex("123".getBytes())); u.setEmail("zs@qq.com"); u.setRegdatetime(new Date());
        return new ResponseData(
                u != null ? 0 : 1 ,
                u != null ? "登录成功" : "登录失败" ,
                u
        ) ;
    }

    // POST   http://localhost:8090/user , 上传信息是json格式数据
    //				{"name":"张三","password":"123"}
    @PostMapping()
    public ResponseData register(@RequestBody User user) {
        System.out.println(user);
        return new ResponseData(
                0 ,
                "注册成功",
                true
        ) ;
    }
    @PostMapping("r2")
    public ResponseData register(@RequestBody Map<String , Object> map) {
        System.out.println(map);
        return new ResponseData(
                0 ,
                "注册成功",
                true
        ) ;
    }

    //request : PUT  	http://localhost:8090/user，上传信息是 js对象
    //				 {id:1,password:"123"} 或者 {id:1,mobile:"12345676453"}
    @PutMapping()
    public ResponseData update(User user) {
        return  new ResponseData(
                0 ,
                "修改成功" ,
                user
        ) ;
    }
}

