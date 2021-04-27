package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {
    @GetMapping("/hello")
    public String greeting(){
        return ("/greeting");
    }
}
