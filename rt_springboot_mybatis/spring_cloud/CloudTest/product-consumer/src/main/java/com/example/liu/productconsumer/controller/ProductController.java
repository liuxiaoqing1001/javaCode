package com.example.liu.productconsumer.controller;

import com.example.liu.productconsumer.bean.Product;
import com.example.liu.productconsumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService ;

    @GetMapping("/product")
    public Product getMess() {
        return  productService.getMess() ;
    }
}
