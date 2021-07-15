package com.example.demo.controller;

import com.example.demo.model.KhuyenMai;
import com.example.demo.service.IKhuyenMaiService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class homeController {
    @Autowired
    IKhuyenMaiService khuyenMaiService;

    @GetMapping
    public String getHome(Model model, @RequestParam(required = false) Double giamgia,
                          @RequestParam(required = false) String ngay1,
                          @RequestParam(required = false) String ngay2){
        if (ngay1==""){
            ngay1=null;
        }
        if (ngay2==""){
            ngay2=null;
        }
        if(giamgia!=null&&ngay1==null&&ngay2==null){
            model.addAttribute("list",khuyenMaiService.findByMucGiamGia(giamgia));
        }else if (giamgia==null&&ngay1!=null&&ngay2==null){
            model.addAttribute("list",khuyenMaiService.findByThoiGianBatDau(ngay1));
        }else if (giamgia==null&&ngay1==null&&ngay2!=null){
            model.addAttribute("list",khuyenMaiService.findByThoiGianKetThuc(ngay2));
        }else if(giamgia!=null&&ngay1!=null&&ngay2!=null){
            model.addAttribute("list",khuyenMaiService.findAllFiled(giamgia,ngay1,ngay2));
        }else {
            model.addAttribute("list",khuyenMaiService.findAll());
        }
        return "/index";
    }
    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("khuyenMai",new KhuyenMai());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Model model, @Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }
        khuyenMaiService.save(khuyenMai);
        return "/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        khuyenMaiService.delete(khuyenMaiService.findById(id).get());
        return "redirect:/";
    }
}
