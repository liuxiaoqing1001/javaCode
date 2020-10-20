package com.example.liu.productconsumer.service;

import com.example.liu.productconsumer.bean.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
    RestTemplate restTemplate ;
    @HystrixCommand(fallbackMethod = "getMessHystrixs")
    public Product getMess() {
        return restTemplate.getForObject("http://product-provider:8602/product/" , Product.class) ;
    }


    public Product getMessHystrixs() {
        Product p = new Product() ;
        p.setId(-1);
        p.setName("获取失败");
        return p;
    }

}
