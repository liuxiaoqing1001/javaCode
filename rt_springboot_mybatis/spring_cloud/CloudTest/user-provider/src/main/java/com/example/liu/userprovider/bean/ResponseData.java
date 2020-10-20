package com.example.liu.userprovider.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private Integer errCode ;
    private String msg;
    private Object data ;
}
