package com.example.liu.newsprovider.controller;

import com.example.liu.newsprovider.bean.News;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class NewsController {
    @GetMapping("/")
    public String root() {
        return "NewsProvider-Controller" ;
    }

    @GetMapping("/pnews/{id}")
    public News getById(@PathVariable("id")Integer id) {
        return new News(id , "868686" , "....") ;
    }

}
