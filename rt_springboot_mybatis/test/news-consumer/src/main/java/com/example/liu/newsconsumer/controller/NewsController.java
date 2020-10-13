package com.example.liu.newsconsumer.controller;

import com.example.liu.bean.ResponseData;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/news")
public class NewsController {
    @GetMapping("{id}")
    public ResponseData getById(@PathVariable("id") Integer id) {
        return new ResponseData(0 , "请求成功" , id) ;
    }
}
