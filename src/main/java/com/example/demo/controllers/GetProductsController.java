package com.example.demo.controllers;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Repository.ProductsRepository;
import com.example.demo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class GetProductsController {
    @Autowired
    ProductsService service;

    @ResponseBody
    @GetMapping("/getProductsData")
    public List<ProductDto> getProducts() {

            return service.getAllProducts();

    }


}
