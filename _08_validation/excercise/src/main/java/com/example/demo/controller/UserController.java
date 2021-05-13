package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("list",userService.findAll());
        return "/index";
    }
    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }
    @PostMapping("/create")
    public String create(Model model, @Valid @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/create";
        }else {
            userService.save(user);
            model.addAttribute("list",userService.findAll());
            return "/index";
        }
    }
}
