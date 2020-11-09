package com.example.demo.controllers;

import com.example.demo.Dto.NewsDto;
import com.example.demo.Dto.ProductDto;
import com.example.demo.Service.NewsService;
import com.example.demo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPanelController {

    @GetMapping("/adminPanel")
    public String addProduct() {
        return "AdminPanel.html";
    }

    @Autowired
    ProductsService productsService;
    @PostMapping("/addProduct")
    public String saveProduct(ProductDto productDto) {
        productsService.saveProduct(productDto);

        return "redirect:/adminPanel";
    }

    @PostMapping("/deleteProduct")
    public String deleteProductByName(String productName) {
        productsService.deleteByName(productName);

        return "redirect:/adminPanel";
    }


    @PostMapping("/editProductCount")
    public String editProductCount(String productName, Integer productCount) {
        productsService.editCountByName(productName,productCount);

        return "redirect:/adminPanel";
    }

    @Autowired
    NewsService newsService;
    @PostMapping("/addNews")
    public String addNews(NewsDto newsDto) {
        newsService.saveNews(newsDto);
        System.out.println(newsDto.getMiniNews());


        return "redirect:/adminPanel";
    }

    @PostMapping("/delNews")
    public String delNews(String title) {
        newsService.deleteNewsByName(title);
        return "redirect:/adminPanel";
    }

}
