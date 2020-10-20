package com.example.liu.userprovider.controller;

import com.example.liu.userprovider.entity.User;
import com.example.liu.userprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("puser")
public class UserController {

    @Autowired
    UserService userService ;

    @GetMapping("/{name}/{pwd}")
    public User login(@PathVariable("name") String name , @PathVariable("pwd") String pass) {
        return userService.login(name , pass) ;
    }

    @PostMapping("/user")
    public boolean register(@RequestBody User user) {//
        return userService.register(user) ;
    }
}
