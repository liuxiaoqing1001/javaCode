package com.example.liu.rest_ful.rest_ful_user.controller.advice;

import com.example.liu.rest_ful.rest_ful_user.bean.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常发生情况下==》返回相关异常信息 ==》全局异常处理
 * ​	    【同Spring框架下SpringMVC处理方案一致】
 * ​	    @ControllerAdvice + @ExceptionHandler
 *
 * 定义一个Controller，注解 @ControllerAdvice，
 * 在该Controller中描述发生不同异常后封装对应异常处理方案，
 * 并返回json数据或者页面 。
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public Map<String , Object> customHandler (SystemException e , HttpServletRequest request) {
        Map<String , Object> map = new HashMap<>() ;
        map.put("errCode" , e.getCode()) ;
        map.put("errMsg" , e.getMessage()) ;
        map.put("comeFrom" , request.getRequestURI()) ;
        return map ;
    }

    //NumberFormatException.class/MethodArgumentTypeMismatchException.class
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Map<String , Object> numberFormat (MethodArgumentTypeMismatchException e , HttpServletRequest request) {
        Map<String , Object> map =  new HashMap<>() ;
        map.put("errCode" , "709") ;
        map.put("errMsg" , e.getMessage()) ;
        map.put("comeFrom" , request.getRequestURI()) ;
        return map ;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultHandler(Exception e , HttpServletRequest request) {
        ModelAndView mav = new ModelAndView() ;
        mav.addObject("exception" , e) ;
        mav.addObject("comeForm" , request.getRequestURI()) ;
        mav.setViewName("error");
        return mav ;
    }
}
