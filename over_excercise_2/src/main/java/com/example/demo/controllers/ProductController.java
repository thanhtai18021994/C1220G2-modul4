package com.example.demo.controllers;

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
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/product")
    public String getIndex(Model model,Pageable page1){
        Pageable pageable=PageRequest.of(page1.getPageNumber(),5);
        Page<Product> page=productService.findAll(pageable);
        model.addAttribute("products",page);
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
        productService.save(product);
        model.addAttribute("products",productService.findAll(page1));
        return "/product/index";
    }

    @PostMapping("/product/search")
    public String search(Model model, @RequestParam Double price1,@RequestParam Double price2,@PageableDefault(value = 5) Pageable pageable){
        Page<Product> products= productService.searchBy(price1,price2,pageable);
        model.addAttribute("products",products);
        return "/product/index";
    }
}
