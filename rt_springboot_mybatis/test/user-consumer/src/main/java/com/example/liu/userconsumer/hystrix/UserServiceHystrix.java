package com.example.liu.userconsumer.hystrix;

import com.example.liu.entity.User;
import com.example.liu.userconsumer.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public User login(String name, String password) {
        User u = new User() ;
        u.setName("熔断，不能获取信息");
        return u;
    }

    @Override
    public int add(User user) {
        return -1;
    }
}
