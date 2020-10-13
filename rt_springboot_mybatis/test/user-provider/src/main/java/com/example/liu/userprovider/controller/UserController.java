package com.example.liu.userprovider.controller;

import com.example.liu.entity.User;
import com.example.liu.userprovider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao ;
    @GetMapping("{name}/{pwd}")
    public User login(@PathVariable("name") String name , @PathVariable("pwd") String pwd) {
        return userDao.login(name , pwd) ;
    }

    @PostMapping
    public int add(User u) {
        return userDao.add(u) ;
    }
}
