package com.example.controllers;

import com.example.model.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImplement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    StudentService studentService=new StudentServiceImplement();

    @GetMapping
    public String displayStudent(Model model){
        model.addAttribute("listStudent",studentService.findAll());
        return "/index";
    }
    @GetMapping("/create")
    public String directStudent(){
        return "/create";
    }
    @PostMapping("/create")
    public String createStudent(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String address){
        studentService.save(new Student(id,name,address));

        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        studentService.delete(id);
        return "redirect:/";
    }
}
