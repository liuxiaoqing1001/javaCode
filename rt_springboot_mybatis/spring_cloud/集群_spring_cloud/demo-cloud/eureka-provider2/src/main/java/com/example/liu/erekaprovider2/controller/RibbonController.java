package com.example.liu.erekaprovider2.controller;

import com.example.liu.erekaprovider2.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//与provider构成集群，功能一样

@CrossOrigin
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Value("${server.port}")
    private String port;

    @GetMapping("port")
    public String port(){
        return "hello,I'm come from provider:"+port;
    }

    @GetMapping("{uid}")
    public User byId(@PathVariable("uid")Integer id){
        User u=new User(id,"张三",new Date());
        return u;
    }

}