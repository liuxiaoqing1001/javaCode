package com.isoft.testmvc.controller;

import com.isoft.testmvc.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/updata")
public class GetUpdataController {

    // http://localhost:8090/updata/testNamePwd?name=张三&pwd=123
    @GetMapping("testNamePwd")
    public Map<String , Object> test1(String name , String pwd) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("username" , name) ;
        map.put("userpass" , pwd) ;
        return map ;
    }

    // http://localhost:8090/updata/testNamePwd2?uname=张三&upass=123
    @GetMapping("testNamePwd2")
    public Map<String , Object> test2(@RequestParam("uname") String name ,@RequestParam("upass") Integer pwd) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("username" , name) ;
        map.put("userpass" , pwd) ;
        return map ;
    }

    // http://localhost:8090/updata/testDate?name=rose&birth=2000-10-23
    @GetMapping("testDate")
    public Map<String , Object> test3(String name , @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("username" , name) ;
        map.put("birth" , birth) ;
        return map ;
    }

    // http://localhost:8090/updata/testObj?uid=1&name=%E6%9D%8E%E5%9B%9B&birth=2000-11-11
//    @GetMapping("testObj")
    @RequestMapping("testObj")
    public User test4(User u) {
        return u ;
    }

    // http://localhost:8090/updata/testPath/张三/123
    @GetMapping("testPath/{name}/{password}")
    public Map<String , Object> test5(@PathVariable("name") String name , @PathVariable("password") Integer pwd) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("username" , name) ;
        map.put("userpass" , pwd) ;
        return map ;
    }
}
