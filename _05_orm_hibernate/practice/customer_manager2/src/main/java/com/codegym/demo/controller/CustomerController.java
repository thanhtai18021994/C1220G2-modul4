package com.codegym.demo.controller;

import com.codegym.demo.entity.Customer;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.ManufactureService;
import com.codegym.demo.service.impl.CustomerServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ManufactureService manufactureService;

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "/index";
    }
    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("manufacture",manufactureService.findAll());
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Model model,@ModelAttribute Customer customer){
        customerService.save(customer);
        model.addAttribute("customers",customerService.findAll());
        return "/index";
    }
    @GetMapping("/update/{id}")
    public String getupdate(@PathVariable Integer id,Model model){
        model.addAttribute("manufacture",manufactureService.findAll());
        model.addAttribute("customer",customerService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer,Model model){
        customerService.save(customer);
        model.addAttribute("customers",customerService.findAll());
        return "/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        customerService.delete(customerService.findById(id));
        model.addAttribute("customers",customerService.findAll());
        return "/index";
    }
}
