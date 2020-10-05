package com.example.liu.rest_ful.rest_ful_user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestErrorController {
    @GetMapping("/test/{id}")
    public String test1(@PathVariable("id") Integer id) {
        return  "TestErrorController:Test1 -- " + id ;
    }

}
