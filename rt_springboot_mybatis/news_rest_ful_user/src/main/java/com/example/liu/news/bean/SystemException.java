package com.example.liu.news.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 自定义全局异常类
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SystemException extends RuntimeException {
    private String code ;
    public SystemException(String msg , String code) {
        super(msg) ;
        this.code = code ;
    }

}
