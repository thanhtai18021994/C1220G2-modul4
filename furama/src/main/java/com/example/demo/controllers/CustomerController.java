package com.example.demo.controllers;

import com.example.demo.model.Cart;
import com.example.demo.model.CustomerType;
import com.example.demo.model.Customer;
import com.example.demo.model.User;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.security.RoleService;
import com.example.demo.service.security.UserService;
import com.example.demo.service.typeCustomer.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
@SessionAttributes("cart")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITypeCustomerService typeCustomerService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @GetMapping
    public String homePage(Model model, Pageable pageable,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String address,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) CustomerType typeCustomer,
                           @SessionAttribute("cart") Cart cart) {
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email=((UserDetails)principal).getUsername();
        User user=userService.findByEmail(email);
        cart.setUser(user);
        Pageable pageable1=PageRequest.of(pageable.getPageNumber(),5);
        if ((name!=null||address!=null||phone!=null)&&typeCustomer!=null){
            model.addAttribute("name",name);
            model.addAttribute("address",address);
            model.addAttribute("phone",phone);
            model.addAttribute("customertype",typeCustomer);
            model.addAttribute("typeCustomer",typeCustomerService.findAll());
            Page<Customer> list=customerService.findAllField(name,address,phone,typeCustomer,pageable1);
            model.addAttribute("list",list);
            return "/homepage/customer/homePage";
        }else if((name!=null||address!=null||phone!=null)&&typeCustomer==null) {
            model.addAttribute("name",name);
            model.addAttribute("address",address);
            model.addAttribute("phone",phone);
            model.addAttribute("typeCustomer",typeCustomerService.findAll());
            Page<Customer> list=customerService.findByNameAndAddressAndPhone(name,address,phone,pageable1);
            model.addAttribute("list",list);
            return "/homepage/customer/homePage";
        }
            model.addAttribute("typeCustomer",typeCustomerService.findAll());
            model.addAttribute("list",customerService.findAll(pageable1));
        return "/homepage/customer/homePage";
    }

    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("typeCustomer",typeCustomerService.findAll());
        return "/homepage/customer/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("typeCustomer",typeCustomerService.findAll());
            return "/homepage/customer/create";
        }else {
            customerService.save(customer);
            model.addAttribute("customer",new Customer());
            model.addAttribute("typeCustomer",typeCustomerService.findAll());
            return "/homepage/customer/create";
        }

    }
    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Integer id,Model model){
        model.addAttribute("customer",customerService.findById(id).get());
        model.addAttribute("typeCustomer",typeCustomerService.findAll());
        return "/homepage/customer/update";
    }
    @PostMapping ("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("typeCustomer",typeCustomerService.findAll());
            return "/homepage/customer/update";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Sửa thông tin thành công");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Customer> customer=customerService.findById(id);
        if(customer.isPresent()){
            customerService.delete(customer.get());
            return "redirect:/customer";
        }
        return "redirect:/customer";
    }
    @GetMapping("/view/{id}")
    public String detail(@PathVariable Integer id,Model model){
        model.addAttribute("object",customerService.findById(id).get());
        return "/homepage/customer/view";
    }
}
