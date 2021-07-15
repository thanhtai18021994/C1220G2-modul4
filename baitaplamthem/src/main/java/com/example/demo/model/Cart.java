package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    private Map<Product,Integer> products=new HashMap<>();
    public void addProduct(Product product,Integer number){
        if(products.containsKey(product)){
            products.put(product,products.get(product)+number);
        }else {
            products.put(product,number);
        }
    }
}
