package com.example.demo.controllers;

import com.example.demo.entity.Province;
import com.example.demo.services.provinceService.ProvinceServiceimplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProvinceController {
    @Autowired
    ProvinceServiceimplement provinceServiceimplement;
    @GetMapping("/province")
    public String getHomePageProvince(Model model){
        model.addAttribute("provinces",provinceServiceimplement.showList());
        return "/province/index";
    }
    @GetMapping("/province/get-create")
    public String getCreate(Model model){
        model.addAttribute("province",new Province());
        return "/province/create";
    }
    @PostMapping("/province/create")
    public String create(@ModelAttribute Province province,Model model){
        provinceServiceimplement.save(province);
        model.addAttribute("provinces",provinceServiceimplement.showList());
        return "/province/index";
    }
    @GetMapping("/province/get-update/{id}")
    public String getUpdate(Model model, @PathVariable Long id){
        model.addAttribute("province",provinceServiceimplement.findById(id));
        return "/province/update";
    }

    @PostMapping("/province/update")
    public String update(@ModelAttribute Province province,Model model){
        provinceServiceimplement.save(province);
        model.addAttribute("provinces",provinceServiceimplement.showList());
        return "/province/index";
    }

    @GetMapping("/province/delete/{id}")
    public String delete(Model model,@PathVariable Long id){
        provinceServiceimplement.delete(provinceServiceimplement.findById(id));
        model.addAttribute("provinces",provinceServiceimplement.showList());
        return "/province/index";
    }
}
