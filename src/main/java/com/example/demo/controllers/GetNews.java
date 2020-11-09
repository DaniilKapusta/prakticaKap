package com.example.demo.controllers;

import com.example.demo.Dto.NewsDto;
import com.example.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GetNews {

    @Autowired
    NewsService newsService;
    @ResponseBody
    @GetMapping("/getNews")
    public List<NewsDto> getNews() {

        return newsService.getNewsAllDto();

    }
}
