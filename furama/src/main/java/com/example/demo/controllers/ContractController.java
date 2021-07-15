package com.example.demo.controllers;

import com.example.demo.model.Cart;
import com.example.demo.model.User;
import com.example.demo.service.security.RoleService;
import com.example.demo.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contract")
@SessionAttributes("cart")
public class ContractController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @GetMapping
    public String getHome(@SessionAttribute("cart") Cart cart){
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email=((UserDetails)principal).getUsername();
        User user=userService.findByEmail(email);
        cart.setUser(user);
        return "/homepage/errorPage";
    }
}
