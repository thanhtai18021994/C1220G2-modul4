package com.example.demo.controllers;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.product.IProductService;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/product")
    public String getIndex(Model model,@RequestParam Optional<String> name,@RequestParam() Optional<String> color, @RequestParam Optional<Double> price1,@RequestParam Optional<Double> price2,@RequestParam Optional<Category> category, Pageable page1){
        Pageable pageable=PageRequest.of(page1.getPageNumber(),5);
        model.addAttribute("categories",categoryService.findAll());
        if ((price1.isPresent()&&price2.isPresent())&&((name.isPresent()||color.isPresent()||category.isPresent()))){
                Page<Product> page=productService.searchBy(name.get(),price1.get(),price2.get(),color.get(),category.get(),pageable);
                model.addAttribute("products",page);
                model.addAttribute("price1",price1.get());
                model.addAttribute("price2",price2.get());
                model.addAttribute("name",name.get());
                model.addAttribute("color",color.get());
                model.addAttribute("category",category.get());
        }else if((name.isPresent()||color.isPresent())){
            if(!category.isPresent()){
                Page<Product> page=productService.searchBy(name.get(), color.get(),pageable);
                model.addAttribute("products",page);
                model.addAttribute("name",name.get());
                model.addAttribute("color",color.get());
            }else {
                Page<Product> page=productService.searchBy(name.get(),color.get(),category.get(),pageable);
                model.addAttribute("products",page);
                model.addAttribute("name",name.get());
                model.addAttribute("color",color.get());
                model.addAttribute("category",category.get());
            }
        }else {
            Page<Product> page=productService.findAll(pageable);
            model.addAttribute("products",page);
        }
        return "/product/index";
    }

    @GetMapping("/product/get-create")
    public String getCreate(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("category",categoryService.findAll());
        return "/product/create";
    }

    @PostMapping("/product/create")
    public String create(Model model, @ModelAttribute Product product,@PageableDefault(value = 5) Pageable page1){
//        product.getProductDetail().setDiscription(product.getProductDetail().getDiscription().replaceAll("\n","<br />"));
        productService.save(product);
        model.addAttribute("products",productService.findAll(page1));
        return "/product/index";
    }

}
