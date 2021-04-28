package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidateEmailController {
     private static final String REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$;";
    @GetMapping("/checkEmail")
    String displayMainPage(){
        return "/checkEmail";
    }
    @PostMapping("/checkEmail")
    public String checkEmail(@RequestParam String email, Model model){
        String notify=null;
        boolean check=email.matches(REGEX);
        if (check){
            notify="thanh cong";
        }else {
            notify="that bai";
        }
        model.addAttribute("notify",notify);
        return "/checkEmail";
    }
}
