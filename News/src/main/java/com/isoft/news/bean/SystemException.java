package com.isoft.news.bean;

import lombok.Data;

/**
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
