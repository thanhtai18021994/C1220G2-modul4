package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PracticeController {
    @GetMapping()
    public String greeting1(){
        return ("greeting");
    }
    @PostMapping("/a")
    public String greeting(Model model, @RequestParam("vnd") String money){
        double a =Integer.parseInt(money)/2100;
        model.addAttribute("money",a);
        return ("greeting");
    }
}
