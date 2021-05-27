package com.example.demo.controllers;

import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.model.EntityService;
import com.example.demo.model.User;
import com.example.demo.service.rentType.IRentTypeService;
import com.example.demo.service.security.RoleService;
import com.example.demo.service.security.UserService;
import com.example.demo.service.serviceType.IServiceTypeService;
import com.example.demo.service.service_object.IServiceService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
@SessionAttributes("cart")
public class ServiceController {
    @Autowired
    IServiceService serviceService;
    @Autowired
    IServiceTypeService serviceTypeService;
    @Autowired
    IRentTypeService rentTypeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }
    @GetMapping
    public String homePage(Pageable pageable, Model model,@SessionAttribute("cart") Cart cart){
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email=((UserDetails)principal).getUsername();
        User user=userService.findByEmail(email);
        cart.setUser(user);
        Pageable pageable1= PageRequest.of(pageable.getPageNumber(),5);
        model.addAttribute("list",serviceService.findAll(pageable1));
        return "/homepage/service/homePage";
    }
    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("service",new EntityService());
        model.addAttribute("rentType",rentTypeService.findAll());
        model.addAttribute("typeService",rentTypeService.findAll());
        return "/homepage/service/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("service") EntityService service, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("rentType",rentTypeService.findAll());
            model.addAttribute("typeService",serviceTypeService.findAll());
            return "/homepage/service/create";
        }else {
            serviceService.save(service);
            model.addAttribute("service",new EntityService());
            model.addAttribute("rentType",rentTypeService.findAll());
            model.addAttribute("typeService",serviceTypeService.findAll());
            return "/homepage/service/create";
        }
    }
    @GetMapping("/view/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("object",serviceService.findById(id).get());
        return "/homepage/service/view";
    }
}
