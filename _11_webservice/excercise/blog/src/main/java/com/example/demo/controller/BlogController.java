package com.example.demo.controller;

import com.example.demo.Service.blog.IBlogService;
import com.example.demo.Service.category.ICategoryService;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("blog",blogService.findAll());
        return "/blog/index";
    }
    @GetMapping("/create/my")
    public ModelAndView getCreateAjax(){
        ModelAndView modelAndView= new ModelAndView("/blog/create2");
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreate(){
       ModelAndView modelAndView= new ModelAndView("/blog/create");
       modelAndView.addObject("blog",new Blog());
       modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable Integer id){
        Optional<Blog> blog=blogService.findById(id);
        model.addAttribute("blog",blog.get());
        return "/blog/view2";
    }
}
