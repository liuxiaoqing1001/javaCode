package com.example.liu.eurekaconsumerfeign.service;

import com.example.liu.eurekaconsumerfeign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "eureka-provider")  // name是要访问的provider的application-name
public interface FeignService2 {
    // provider所暴露的接口的controller注解uri

    @GetMapping("/ribbon/port")
    public String getPort();

    @GetMapping("/ribbon/{uid}")
    public User getById(@PathVariable("uid")Integer id);
}
