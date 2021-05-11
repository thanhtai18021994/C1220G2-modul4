package com.example.demo.controller;

import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/category")
    public String getIndex(@RequestParam("num1") Integer num1, Model model){
        model.addAttribute("categorys",iCategoryService.findAll(num1));
        return "/category/index";
    }
}
