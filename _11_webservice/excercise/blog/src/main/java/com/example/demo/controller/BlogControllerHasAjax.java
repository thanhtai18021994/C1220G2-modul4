package com.example.demo.controller;

import com.example.demo.Service.blog.IBlogService;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogControllerHasAjax {

    @Autowired
    IBlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> saveBlogR(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.saveR(blog),HttpStatus.CREATED);
    }

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
