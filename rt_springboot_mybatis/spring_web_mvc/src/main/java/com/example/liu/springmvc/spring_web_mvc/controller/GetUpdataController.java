package com.example.liu.springmvc.spring_web_mvc.controller;

import com.example.liu.springmvc.spring_web_mvc.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

///**
// * 获取客户端上传数据
// * ​	1）客户端上传数据，controller的方法参数名和客户端上传参数名一致 ==》自动获取；所支持的数据类型有 String，int，double，boolean
// * ​	2）客户端上传数据参数名与controller方法参数名不一致 ==》使用@RequestParam("客户端上传参数名")
// * ​	3）客户端上传的数据参数名如果和类成员变量名一致 ==》controller的方法参数类型可以是该类的实例对象
// * ​	4）客户端上传的字符串，如果需要映射为java.util.Date类型，需要使用 @DateTimeFormat注解，来说明String转换为Date的格式
// */

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
    // 上传参数不一致，需要映射，否则为null
    // name ！= uname
    // pwd  ！= upass
    @GetMapping("testNamePwd2")
    public Map<String , Object> test2(@RequestParam("uname") String name ,@RequestParam("upass") Integer pwd) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("username" , name) ;
        map.put("userpass" , pwd) ;
        return map ;
    }

    // http://localhost:8090/updata/testDate?name=rose&birth=2000-10-23
    // 自动映射为Date类型
    @GetMapping("testDate")
    public Map<String , Object> test3(String name , @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("username" , name) ;
        map.put("birth" , birth) ;
        return map ;
    }

    // http://localhost:8090/updata/testObj?uid=1&name=%E6%9D%8E%E5%9B%9B&birth=2000-11-11
//    @GetMapping("testObj")
    // 自动映射为一个对象
    @RequestMapping("testObj")
    public User test4(User u) {
        return u ;
    }

    // http://localhost:8090/updata/testPath/张三/123
    // 客户端上传数据，将路径上的name映射为name：@PathVariable("name") String name
    @GetMapping("testPath/{name}/{password}")
    public Map<String , Object> test5(@PathVariable("name") String name , @PathVariable("password") Integer pwd) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("username" , name) ;
        map.put("userpass" , pwd) ;
        return map ;
    }
}
