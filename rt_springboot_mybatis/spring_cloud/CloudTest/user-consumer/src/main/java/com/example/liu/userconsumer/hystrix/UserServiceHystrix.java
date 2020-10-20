package com.example.liu.userconsumer.hystrix;

import com.example.liu.userconsumer.entity.User;
import com.example.liu.userconsumer.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public User login(String name, String pass) {
        User u = new User() ;
        u.setId(400);
        u.setName("发生熔断");
        return u;
//        User u = userService.login(name , pass) ;
//        return new ResponseData(
//                400,
//                "error",
//                null
//        ) ;
    }

//    @Override
//    public boolean register(User user) {
//        return  false ;
//    }
}
