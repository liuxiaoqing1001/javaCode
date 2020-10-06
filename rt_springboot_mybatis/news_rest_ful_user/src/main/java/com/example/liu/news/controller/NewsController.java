package com.example.liu.news.controller;

import com.example.liu.news.bean.Page;
import com.example.liu.news.bean.ResponseData;
import com.example.liu.news.entity.News;
import com.example.liu.news.service.NewsService;
import com.example.liu.news.service.NewstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/system/news")
public class NewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    NewstypeService newstypeService;

    @GetMapping("newstype")
    public ResponseData newstype(){
        return new ResponseData(
                0,
                "请求成功",
                newstypeService.getAll()
        );

    }

    @GetMapping("page")
    public Map<String,Object> page(Integer curPage, Integer size, Integer typeid,
                                   String title, @DateTimeFormat(pattern = "yyyy年MM月dd日") Date pubdate){
        Page<News> page=newsService.newsPage(typeid,title,pubdate,curPage,size);
        Map<String,Object> map= new HashMap<>();
        map.put("total",page.getRowCount());
        map.put("rows",page.getData());
        return map;
    }

    @GetMapping("{id}")
    public ResponseData getById(@PathVariable("id") Integer id) {
        News n = newsService.getById(id) ;
        return new ResponseData(
                n != null ? 0 : 1 ,
                n != null ? "请求到数据" : "请求失败" ,
                n
        ) ;
    }

    @PostMapping
    public ResponseData add(News n) {
        boolean r = newsService.add(n) ;
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "添加成功" : "添加失败" ,
                r
        ) ;
    }

    @DeleteMapping("{id}")
    public ResponseData delById(@PathVariable("id") Integer id) {
        boolean r = newsService.delById(id) ;
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "删除成功" : "删除失败" ,
                r
        ) ;
    }
    @DeleteMapping("ids")
    public ResponseData delByIds(Integer[] id) {
        boolean r = newsService.delByIds(Arrays.asList(id)) ;
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "删除成功" : "删除失败" ,
                r
        ) ;
    }

    @PutMapping
    public ResponseData update(News n) {
        boolean r = newsService.updateById(n) ;
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "更新成功" : "更新失败" ,
                r
        ) ;
    }

}
