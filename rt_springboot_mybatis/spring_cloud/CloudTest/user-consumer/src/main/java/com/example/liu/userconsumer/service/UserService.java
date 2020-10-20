package com.example.liu.userconsumer.service;

import com.example.liu.userconsumer.entity.User;
import com.example.liu.userconsumer.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "user-provider" , fallback = UserServiceHystrix.class)
public interface UserService {
    @GetMapping("/puser/{name}/{pwd}")
    public User login(@PathVariable("name") String name, @PathVariable("pwd") String pass) ;

//    @PostMapping("/puser/user")
//    public boolean register(User user) ;
}
