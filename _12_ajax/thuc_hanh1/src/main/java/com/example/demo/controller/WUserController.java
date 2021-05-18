package com.example.demo.controller;

import com.example.demo.repository.IUserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WUserController {
    @Autowired
    UserService userService;
    @GetMapping
    public String home(Model model){
        model.addAttribute("users",userService.findAll());
        return "/index";
    }
}
