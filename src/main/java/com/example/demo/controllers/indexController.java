package com.example.demo.controllers;

import com.example.demo.Repository.ProductsRepository;
import com.example.demo.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.File;

@Controller
public class indexController {
    @Autowired
    ProductsRepository productsRepository;
    @GetMapping("/index")
    public String index() {
        return "index.html";
    }


}
