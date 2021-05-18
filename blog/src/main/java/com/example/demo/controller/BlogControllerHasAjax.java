package com.example.demo.controller;

import com.example.demo.Service.blog.IBlogService;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogControllerHasAjax {

    @Autowired
    IBlogService blogService;

    @PostMapping("/create")
    public String saveBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return "redirect:/show";
    }

    @GetMapping("/show")
    public ModelAndView showAllBlog(){
        return new ModelAndView("/blog/index","blogs",blogService.findAll());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> allBlog(){
        return new ResponseEntity<>(blogService.findAll(),HttpStatus.OK);
    }
}
