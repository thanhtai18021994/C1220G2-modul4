package com.springmvc.controllers;

import com.springmvc.service.Caculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    Caculator caculator=new Caculator();
    @GetMapping("/caculator")
    public String mainPage(){
        return "/caculator";
    }
    @PostMapping("/tinhtoan")
    public String caculator(@RequestParam int num1,
                            @RequestParam int num2,
                            @RequestParam String pheptinh, Model model){
        switch (pheptinh){
            case "phepcong":
                model.addAttribute("result",caculator.phepCong(num1,num2));
                break;
            case "pheptru":
               model.addAttribute("result", caculator.phepTru(num1,num2));
                break;
            case "phepnhan":
                model.addAttribute("result",caculator.phepNhan(num1,num2));
                break;
            default:
                model.addAttribute("result",caculator.phepChia(num1,num2));
        }
        return "/caculator";
    }
}
