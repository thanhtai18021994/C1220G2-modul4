package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> showAll();
    List<Product> search(String text);
    void save(Product product);
    void update(Product product,int id);
    void delete(int id);
    Product findById(int id);
}
