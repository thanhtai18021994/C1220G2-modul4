package com.example.demo.model;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products;

    public Cart() {
        products=new HashMap<>();
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
//        for (Map.Entry<Product,Integer> entry:products.entrySet()){
//            if (product.equals(entry.getKey())){
//                products.replace(product,entry.getValue(),entry.getValue()+1);
//            }else {
//                products.put(product,1);
//            }
//        }
        if(products.containsKey(product)){
            products.replace(product,products.get(product),products.get(product)+1);
        }else {
            products.put(product,1);
        }
    }

    public Integer countProduct(Product product){
        return products.get(product);
    }

    public Double priceOfProducts(Product product){
        return product.getNewPrice()*countProduct(product);
    }

    public Double total(){
        Double prices=0.0;
        for (Map.Entry<Product,Integer> entry:products.entrySet()){
            prices+=priceOfProducts(entry.getKey());
        }
        return prices;
    }
}
