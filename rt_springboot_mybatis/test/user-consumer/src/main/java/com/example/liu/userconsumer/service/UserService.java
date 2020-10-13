package com.example.liu.userconsumer.service;

import com.example.liu.entity.User;
import com.example.liu.userconsumer.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "user-provider" , fallback = UserServiceHystrix.class)
public interface UserService {

    @GetMapping("/user/{name}/{pwd}")
    User login(@PathVariable("name") String name , @PathVariable("pwd") String pwd) ;

    @PostMapping("/user")
    public int add(User u) ;
}
