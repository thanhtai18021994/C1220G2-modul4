package com.example.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//add annotation controller
@Controller
public class GreetingControler {
    @GetMapping("/")
    public String greeting(){
        return "/greeting";
    }
}
