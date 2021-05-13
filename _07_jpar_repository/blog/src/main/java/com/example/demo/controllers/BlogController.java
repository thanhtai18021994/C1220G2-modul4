package com.example.demo.controllers;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("list",blogService.findAll());
        return "/index";
    }
    @PostMapping("/create")
    public String create(Blog blog,Model model){

    }
}
