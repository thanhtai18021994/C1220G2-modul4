package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("list",userService.findAll());
        return "/index";
    }

    @GetMapping("/get-create")
    public String getCreate(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute User user, BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }else {
            userService.save(user);
            model.addAttribute("list",userService.findAll());
            return "/index";
        }
    }
}
