package com.example.liu.newsconsumer.controller;

import com.example.liu.newsconsumer.bean.News;
import com.example.liu.newsconsumer.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService ;

    @GetMapping("/{id}")
    public News getById(@PathVariable("id")Integer id) {
        return  newsService.getById(id) ;
    }
}
