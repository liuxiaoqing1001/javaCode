package com.example.liu.erekaconsumer.service;

import com.example.liu.erekaconsumer.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixService {
    @Autowired
    RestTemplate restTemplate;

//    在需要发送远程访问其他组件的Service的需要熔断处理的方法上添加
//    @HystrixCommand注解

    @HystrixCommand(fallbackMethod = "getPortHystrix")
    public String getPort(){
        return restTemplate.getForObject("http://eureka-provider/ribbon/port",String.class );
    }

    @HystrixCommand(fallbackMethod = "getByIdHystrix")
    public User getById(Integer id){
        return restTemplate.getForObject("http://eureka-provider/ribbon/" + id , User.class) ;
    }

    public String getPortHystrix() {    //调用方法类型与getPort类型相同 String
        return "发生熔断，请求不到Provider" ;
    }

    public User getByIdHystrix(Integer id) {    //与getById User
        User u = new User() ;
        u.setId(-1);
        u.setName("请求不可到达!");
        return u ;
    }
}
