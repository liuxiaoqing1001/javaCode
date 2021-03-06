package com.example.liu.news.controller;

import com.example.liu.news.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
