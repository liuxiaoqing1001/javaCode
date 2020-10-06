package com.isoft.news.controller.advice;

import com.isoft.news.bean.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Map<String , Object> numberFormat (MethodArgumentTypeMismatchException e , HttpServletRequest request) {
        Map<String , Object> map = new HashMap<>() ;
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
