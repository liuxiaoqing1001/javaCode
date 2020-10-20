package com.example.liu.newsconsumer.service;

import com.example.liu.newsconsumer.bean.News;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {
    @Autowired
    RestTemplate restTemplate ;
    @HystrixCommand(fallbackMethod = "getByIdHystrixs")
    public News getById(Integer id) {
        if(null == id) {
            return null ;
        }
        return restTemplate.getForObject("http://news-provider:7007/pnews/"+id , News.class) ;
    }


    public News getByIdHystrixs(Integer id) {
        return null ;
    }

}
