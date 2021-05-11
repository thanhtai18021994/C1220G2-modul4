package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentServiceImplement departmentServiceImplement;
    @GetMapping
    public ModelAndView findDePartMent(){
        ModelAndView modelAndView=new ModelAndView("/index");
        modelAndView.addObject("departments",departmentServiceImplement.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreate(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("department",new Department());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Department department, Model model){
        departmentServiceImplement.save(department);
        model.addAttribute("departments",departmentServiceImplement.findAll());
        return "/index";
    }
    @GetMapping("/search")
    public String search(Model model, @RequestParam String text){
        model.addAttribute("departments",departmentServiceImplement.search(text));
        return "/index";
    }
    @GetMapping("/count")
    public String count(Model model){
        model.addAttribute("departments",departmentServiceImplement.count());
        return "/count";
    }
}
