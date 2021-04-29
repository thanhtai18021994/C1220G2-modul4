package com.codegym.controllers;

import com.codegym.model.MailBox;
import com.codegym.repository.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MailBoxController {
    Data data=new Data();

    @GetMapping()
    private String mainpage(Model model){
        model.addAttribute("listCountry",data.getCountry());
        model.addAttribute("listSize",data.getListSize());
        model.addAttribute("mailBox",new MailBox());
        return "/update";
    }

    @GetMapping("/update")
    private String update(@ModelAttribute MailBox mailBox,Model model){
        model.addAttribute("mailBox",mailBox);
        return "/index";
    }
//    @GetMapping("/updateAgian")
//    private String updateAgain()
}
