package com.example.liu.news.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsType implements Serializable {
    private Integer id ;
    private String typename ;
    /**
     * 该类别下新闻
     */
    private ArrayList<News> newsList ;
}
