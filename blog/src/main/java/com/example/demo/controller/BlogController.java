package com.example.demo.controller;

import com.example.demo.Service.blog.IBlogService;
import com.example.demo.Service.category.ICategoryService;
import com.example.demo.dto.BlogDto;
import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public String getIndex(Model model){
        Pageable pageable= PageRequest.of(0,4);
        model.addAttribute("blogs",blogService.findAll(pageable).getContent());
        return "/blog/index";
    }

    @GetMapping("/{num}")
    public String getIndex(Model model,@PathVariable Integer num){
        Pageable pageable= PageRequest.of(num,4);
        model.addAttribute("blogs",blogService.findAll(pageable).getContent());
        return "/blog/search";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog,Model model){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView getCreate(){
       ModelAndView modelAndView= new ModelAndView("/blog/create2");
       modelAndView.addObject("blog",new Blog());
       modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

//    @RequestMapping(value = "/api/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Blog create(@RequestBody BlogDto blogDto){
//        Blog blog=new Blog();
//        blog.setTitle(blogDto.getTitle());
//        blog.setContent(blogDto.getContent());
//        blog.setImage(blogDto.getImage());
//        Category category=categoryService.findById(blogDto.getIdCategory()).get();
//        Category category1=new Category(category.getId(),category.getNameCategory());
//        blog.setCategory(category1);
//        blog.setDate(blogDto.getDate());
//        Blog blog1=blogService.save(blog);
//        return blog1;
//    }

    @GetMapping("/search/{text}")
    public String search(@PathVariable String text,Model model){
        model.addAttribute("blogs",blogService.filter(text));
        return "/blog/search";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable Integer id){
        Optional<Blog> blog=blogService.findById(id);
        model.addAttribute("blog",blog.get());
        return "/blog/view2";
    }
    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user",new User());
        return "/blog/login";
    }

}
