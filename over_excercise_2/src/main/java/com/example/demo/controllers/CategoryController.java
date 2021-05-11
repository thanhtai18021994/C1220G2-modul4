package com.example.demo.controllers;

import com.example.demo.entity.Category;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String getIndex(Model model){
        Pageable pageable= PageRequest.of(0,5);
        Page<Category> categories=categoryService.findAll(pageable);
        model.addAttribute("categories",categories);
        return "/category/index";
    }
}
