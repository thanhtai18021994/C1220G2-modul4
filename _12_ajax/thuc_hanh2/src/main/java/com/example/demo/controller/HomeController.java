package com.example.demo.controller;

import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    ICustomerService customerService;

    @GetMapping
    public ModelAndView getHome(Pageable pageable ){
        return new ModelAndView("/index","customers", customerService.findAll(pageable));
    }
}
