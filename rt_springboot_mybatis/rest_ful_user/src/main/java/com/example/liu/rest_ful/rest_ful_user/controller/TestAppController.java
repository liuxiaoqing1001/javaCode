package com.example.liu.rest_ful.rest_ful_user.controller;

import com.example.liu.rest_ful.rest_ful_user.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// application-dev.properties测试
// http://localhost:8088/v
// http://localhost:8088/c

@CrossOrigin
@RestController
public class TestAppController {
    @Value("${user.info}")
    private String userInfo ;

    @GetMapping("v")
    public String  test() {
        return userInfo ;
    }

    @Autowired
    Person person ;
    @GetMapping("c")
    public Person test2() {
        return person ;
    }
}
