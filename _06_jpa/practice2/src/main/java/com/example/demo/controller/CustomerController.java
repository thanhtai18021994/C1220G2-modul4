package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImplement;
import com.example.demo.service.ProvinceServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebParam;

@Controller
public class CustomerController {
    @Autowired
    CustomerServiceImplement customerServiceImplement;
    ProvinceServiceImplement provinceServiceImplement;
    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("customers",customerServiceImplement.showAll());
        return "/index";
    }
    @GetMapping("create")
    public String getCreate(Model model){
        model.addAttribute("province",provinceServiceImplement.showAll());
        model.addAttribute("customer",new Customer());
        return "/create";
    }
}
