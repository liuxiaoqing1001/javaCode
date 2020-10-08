package com.example.liu.erekaconsumer.service;

import com.example.liu.erekaconsumer.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    public String getPort(){
        return restTemplate.getForObject("http://eureka-provider/ribbon/port",String.class);
    }

    public User getById(Integer id){
        return restTemplate.getForObject("http://eureka-provider/ribbon/" + id , User.class) ;
    }
}
