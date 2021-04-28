package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SandwichController {
    @GetMapping
    public String redirect(){
        return "/index";
    }
    @GetMapping("/giavi")
    public String danhsachgiavi(Model model, @RequestParam(value ="gv",defaultValue ="nothing") String[] gv){
        model.addAttribute("danhsach",gv);
        return "/index";
    }
}
