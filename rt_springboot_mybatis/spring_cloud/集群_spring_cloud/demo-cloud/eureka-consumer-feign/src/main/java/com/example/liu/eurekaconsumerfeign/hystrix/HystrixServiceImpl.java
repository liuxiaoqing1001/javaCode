package com.example.liu.eurekaconsumerfeign.hystrix;

import com.example.liu.eurekaconsumerfeign.entity.User;
import com.example.liu.eurekaconsumerfeign.service.HystrixService;
import org.springframework.stereotype.Component;

@Component
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String getPort() {
        return "Feign--getPort--hystrix";
    }

    @Override
    public User getById(Integer id) {
        User u = new User();
        u.setId(-1);
        return u;
    }
}
