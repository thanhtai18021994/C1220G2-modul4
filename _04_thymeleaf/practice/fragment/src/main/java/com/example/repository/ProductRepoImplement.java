package com.example.repository;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepoImplement implements ProductRepo{
    private static Map<Integer,Product> productMap;
    private static List<String> listManufacture;
    static {
        productMap=new HashMap<>();
        productMap.put(1,new Product(1,"iphone 11",1000,"iphone"));
        productMap.put(2,new Product(2,"iphone 10",900,"iphone"));
        productMap.put(3,new Product(3,"iphone 8",800,"iphone"));
        productMap.put(4,new Product(4,"A71",1500,"samsung"));
        listManufacture=new ArrayList<>();
        listManufacture.add("iphone");
        listManufacture.add("samsung");
        listManufacture.add("nokia");
        listManufacture.add("oppo");
        listManufacture.add("motorola");
    }
    @Override
    public List<Product> showAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public List<Product> search(String text) {
        List<Product> productList=new ArrayList<>();
        for (int i = 0; i <productMap.size() ; i++) {
            if(productMap.get(i).getName().contains(text)){
                productList.add(productMap.get(i));
            };
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void update(Product product, int id) {
        productMap.replace(id,product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}
