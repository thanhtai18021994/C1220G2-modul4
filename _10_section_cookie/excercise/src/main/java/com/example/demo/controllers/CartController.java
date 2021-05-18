package com.example.demo.controllers;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @GetMapping("/shopping")
    public String getProduct(Model model){
        model.addAttribute("products",productService.findAll());
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String addCart(@SessionAttribute("cart") Cart cart, @PathVariable Integer id){
        Product product=productService.findById(id);
        cart.addProduct(product);
        return "redirect:/shopping";
    }

    @GetMapping("/shopping-cart")
    public String showCart(@ModelAttribute Cart cart,Model model){
        model.addAttribute("cart",cart);
        return "/cart";
    }

}
