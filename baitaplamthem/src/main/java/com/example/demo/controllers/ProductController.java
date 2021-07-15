package com.example.demo.controllers;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public String getIndex(Model model, Pageable pageable){
        Pageable pageable1= PageRequest.of(0,5, Sort.Direction.ASC,"priceProduct");
        model.addAttribute("list",productService.findAll(pageable));
        return "layer1/product/home";
    }
    @GetMapping("/order")
    public String getOrder(){
        return "/layer1/order/order";
    }
}
