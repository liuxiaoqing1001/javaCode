package com.example.liu.springmvc.spring_web_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

///**
// * 类上方注解：
// * @Controller
// * @RestController        --@ResponseBody=@Controller
// * @RequestMapping("uri")    --设置当前controller中所有方法访问虚拟路径前缀
// *
// *
// * 方法上方的注解：
// * --设置虚拟路径及请求方式
// * @RequestMapping
// * @GetMapping
// * @PostMapping
// * @PutMapping
// * @DeleteMapping
// */

@Controller
@RequestMapping("/demoReturn")
public class DemoController {

//    浏览器：localhost:8090/demoReturn/testString
    // 请求改方法，将返回客户端 hi.html页面
    @GetMapping("testString")
    public String test1() {
        System.out.println("Call DemoController.test1");
        return "hi" ;
    }

//    浏览器：localhost:8090/demoReturn/testmav
    @GetMapping("testmav")
    public ModelAndView test2() {
        ModelAndView mav = new ModelAndView() ;
        mav.addObject("uname" , "张三") ;
        mav.setViewName("pages/test2");
        return mav ;
    }

//    浏览器：localhost:8090/demoReturn/testjson
    @GetMapping("testjson")
    @ResponseBody
    public Map<String , Object> test3() {
        Map<String , Object> map = new HashMap<>() ;
        map.put("loginame" , "张三") ;
        map.put("loginpass" , "1234") ;
        return map ;
    }
}
