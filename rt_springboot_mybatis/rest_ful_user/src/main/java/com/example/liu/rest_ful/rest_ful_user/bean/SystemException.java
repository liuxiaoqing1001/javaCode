package com.example.liu.rest_ful.rest_ful_user.bean;

import lombok.Data;

/**
 * 异常发生情况下==》返回相关异常信息 ==》全局异常处理
 * ​	    【同Spring框架下SpringMVC处理方案一致】
 * ​	    @ControllerAdvice + @ExceptionHandler
 *
 * 自定义全局异常类
 */
@Data
public class SystemException extends RuntimeException {
    private String code ;
    public SystemException(String msg , String code) {
        super(msg) ;
        this.code = code ;
    }
}
