package com.example.demo.controllers;

import com.example.demo.entity.Customer;
import com.example.demo.services.customerService.CustomerService;
import com.example.demo.services.customerService.CustomerServiceImplement;
import com.example.demo.services.provinceService.ProvinceServiceimplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.print.DocFlavor;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerServiceImplement customerServiceImplement;
    @Autowired
    ProvinceServiceimplement provinceServiceimplement;

    @GetMapping("/customer")
    public String getIndex(Model model, @PageableDefault() Pageable page, @RequestParam Optional<String> search){
        if (search.isPresent()) {
            model.addAttribute("customers", customerServiceImplement.search(search.get(),page));
        }else {
            model.addAttribute("customers", customerServiceImplement.findAll(page));
        }
        return "/customer/index";
    }

    @GetMapping("/customer/get-create")
    public ModelAndView getCreate(Model model){
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        modelAndView.addObject("provinces",provinceServiceimplement.showList());
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public String create(Model model, @ModelAttribute Customer customer){
        customerServiceImplement.save(customer);
        model.addAttribute("customers",customerServiceImplement.showList());
        return "/customer/index";
    }

    @GetMapping("/customer/get-update/{id}")
    public ModelAndView getUpdate(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("/customer/update");
        modelAndView.addObject("provinces",provinceServiceimplement.showList());
        modelAndView.addObject("customer",customerServiceImplement.findById(id));
        return modelAndView;
    }

    @PostMapping("/customer/update")
       public String update(Customer customer,Model model,@PageableDefault(value =(5))Pageable pageable){
        customerServiceImplement.save(customer);
        model.addAttribute("customers",customerServiceImplement.findAll(pageable));
        return "/customer/index";
    }

        @GetMapping("/customer/delete/{id}")
        public String delete(Model model,@PathVariable Long id,@PageableDefault(value =(5))Pageable pageable){
        customerServiceImplement.delete(customerServiceImplement.findById(id));
        model.addAttribute("customers",customerServiceImplement.findAll(pageable));
        return "/customer/index";
       }
}
