package com.example.controllers;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EmployeeController {
    @GetMapping
    public  String mainPage(Model model){
        model.addAttribute("employee",new Employee());
        return "/create";
    }
    @GetMapping("/create")
    public String createEmployee(Model model, @ModelAttribute Employee employee){
        model.addAttribute("employee",employee);
        return "/index";
    }
}
