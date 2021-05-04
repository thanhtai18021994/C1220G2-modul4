package com.codegym.controllers;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping
    public String getIndex(Model model){
        List<User> userList=new ArrayList<>();
        userList.add(new User("User1","Address1",1));
        userList.add(new User("User2","Address2",2));
        userList.add(new User("User3","Address3",3));
        userList.add(new User("User4","Address4",4));
        model.addAttribute("listUser",userList);
        return "model-index";
    }
}
