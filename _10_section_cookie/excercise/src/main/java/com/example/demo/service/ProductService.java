package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {
    @Autowired
    ProductRepository productRepository;
    public List<Product> findAll( ){
        return productRepository.findAll();
    }
    public Product findById(Integer id){
        return productRepository.findById(id).orElse(null);
    }
}
