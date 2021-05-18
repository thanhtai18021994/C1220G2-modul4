package com.example.demo.model;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products=new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
    public void addProduct(Product product){
        for (Map.Entry<Product,Integer> entry:products.entrySet()){
            if (product.equals(entry.getKey())){
                products.replace(product,entry.getValue()+1);
            }else {
                products.put(product,1);
            }
        }
    }
}
