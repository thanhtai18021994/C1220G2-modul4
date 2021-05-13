package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findByPriceBetween(Double price1, Double price2,Pageable pageable);
    Page<Product> findByNameContainingAndPriceBetweenAndColorContainingAndCategory(String name,Double price1,Double price2,String color,Category category, Pageable pageable);
    Page<Product> findByNameContainingAndColorContaining(String text,String color, Pageable pageable);
    Page<Product> findByNameContainingAndColorContainingAndCategory(String name, String color,Category category,Pageable pageable);
    Page<Product> findByCategory(Category category,Pageable pageable);
    Page<Product> findByNameContaining(String  text,Pageable pageable);

}
