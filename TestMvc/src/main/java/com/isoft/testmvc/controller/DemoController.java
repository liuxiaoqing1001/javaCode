package com.isoft.testmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/demoReturn")
public class DemoController {

    // 请求改方法，将返回客户端 hi.html页面
    @GetMapping("testString")
    public String test1() {
        System.out.println("Call DemoController.test1");
        return "hi" ;
    }

    @GetMapping("testmav")
    public ModelAndView test2() {
        ModelAndView mav = new ModelAndView() ;
        mav.addObject("uname" , "张三") ;
        mav.setViewName("pages/test2");
        return mav ;
    }

    @GetMapping("testjson")
    @ResponseBody
    public Map<String , Object> test3() {
        Map<String , Object> map = new HashMap<>() ;
        map.put("loginame" , "张三") ;
        map.put("loginpass" , "1234") ;
        return map ;
    }
}
