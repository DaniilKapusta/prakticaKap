package com.example.demo.controllers;

import com.example.demo.Dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BuyPageController {

    @GetMapping("/buyPage")
    public ModelAndView buyPage(Float allPrice) {
        return new ModelAndView("buyPage.html","allPrice",allPrice);
    }

    @PostMapping("/buy")
    public String buy(Float allPrice, HttpServletRequest req) {
        Map<String, String[]> test = req.getParameterMap();
        for (String key : test.keySet()) {
            String[] strArr = test.get(key);
            for (String val : strArr) {
                System.out.println(key + " = " + val);
            }
        }


        return "redirect:/index";
    }
}
