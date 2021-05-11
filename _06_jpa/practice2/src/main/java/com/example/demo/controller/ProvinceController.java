package com.example.demo.controller;

import com.example.demo.service.ProvinceServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProvinceController {
    @Autowired
    ProvinceServiceImplement provinceServiceImplement;

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("provinces",provinceServiceImplement.showAll());
        return "/index";
    }
}
