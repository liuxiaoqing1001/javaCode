package com.example.liu.userconsumer.hystrix;

import com.example.liu.userconsumer.entity.User;
import com.example.liu.userconsumer.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public User login(String name, String pass) {
        return null;
    }

    @Override
    public boolean register(User user) {
        return  false ;
    }
}
