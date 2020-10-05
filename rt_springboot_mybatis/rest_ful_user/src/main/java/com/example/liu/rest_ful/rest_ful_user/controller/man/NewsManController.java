package com.example.liu.rest_ful.rest_ful_user.controller.man;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/admin/news")
public class NewsManController {
    @GetMapping
    public String testInterceptor() {
        return "管理员未登录不能获取该请求!" ;
    }
}
