package com.isoft.news.controller.man;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AuthTestController {
    @GetMapping("/deny")
    public String testInterceptor() {
        return "管理员未登录不能获取该请求!" ;
    }
    @GetMapping("/login")
    public String testInterceptor2() {
        return "Login check" ;
    }
}
