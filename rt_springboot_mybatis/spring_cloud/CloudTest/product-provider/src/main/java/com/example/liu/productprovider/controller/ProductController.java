package com.example.liu.productprovider.controller;

import com.example.liu.productprovider.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    Product product ;

    @GetMapping("/product")
    public Product getMess() {
        return product;
    }
}
