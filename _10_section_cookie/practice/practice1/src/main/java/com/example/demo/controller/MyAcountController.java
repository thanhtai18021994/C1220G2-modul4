package com.example.demo.controller;

import com.example.demo.model.MyCount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;

@Controller
@SessionAttributes("mycounter")
public class MyAcountController {

    @ModelAttribute("mycounter")
    public MyCount setUpCounter() {
        return new MyCount();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("mycounter") MyCount myCounter) {
        myCounter.increment();
        return "/index";
    }
}
