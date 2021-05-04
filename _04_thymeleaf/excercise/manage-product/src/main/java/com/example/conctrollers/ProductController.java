package com.example.conctrollers;

import com.example.model.Product;
import com.example.repository.ProductRepoImplement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;

@Controller
public class ProductController {
    ProductRepoImplement productRepoImplement=new ProductRepoImplement();
    @GetMapping
    public String homePage(Model model){
        model.addAttribute("products",productRepoImplement.showAll());
        return "/index";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("listmanufac",productRepoImplement.getListManufacture());
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String saveProduct(Product product,Model model){
        productRepoImplement.save(product);
        model.addAttribute("products",productRepoImplement.showAll());
        return "/index";
    }
    @GetMapping("/product/{id}/update")
    public String updatePage(@PathVariable int id,Model model){
        model.addAttribute("linesman",productRepoImplement.getListManufacture());
        model.addAttribute("product",productRepoImplement.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute  Product product, Model model){
        productRepoImplement.update(product,product.getId());
        model.addAttribute("products",productRepoImplement.showAll());
        return "/index";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        productRepoImplement.delete(id);
        model.addAttribute("products",productRepoImplement.showAll());
        return "/index";
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productRepoImplement.findById(id));
        return "/view";
    }
}
