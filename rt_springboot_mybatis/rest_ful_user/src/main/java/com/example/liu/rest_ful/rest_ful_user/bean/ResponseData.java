package com.example.liu.rest_ful.rest_ful_user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData implements Serializable {
    private Integer errCode ;
    private String msg ;
    private Object data ;
}
