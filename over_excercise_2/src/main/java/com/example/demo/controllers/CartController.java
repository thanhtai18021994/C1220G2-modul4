package com.example.demo.controllers;

import com.example.demo.entity.Cart;
import com.example.demo.service.cart.CartService;
import com.example.demo.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @Autowired
    ICartService cartService;
    @GetMapping("/cart")
    public String getIndex(Model model, @PageableDefault(value = 5)Pageable pageable){
        Page<Cart> cartPage=cartService.findAll(pageable);
        model.addAttribute("list",cartPage);
        return "/cart/index";
    }
    @GetMapping("/cart/view/{id}")
    public String view(Model model, @PathVariable Integer id){
        model.addAttribute("product",cartService.findById(id).get());
        return "/cart/view";
    }
}
