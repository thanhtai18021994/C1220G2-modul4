package com.example.demo.service.product;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> search(String text, Pageable pageable) {
        return productRepository.findByNameContaining(text,pageable);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product object) {
        productRepository.save(object);
    }

    @Override
    public void delete(Product object) {
        productRepository.delete(object);
    }

    public Page<Product> searchBy(Double price1,Double price2,Pageable pageable){
       return productRepository.findByPriceBetween(price1,price2,pageable);
    }
    public Page<Product> searchBy(String name ,String color ,Pageable pageable){
        return productRepository.findByNameContainingAndColorContaining(name,color,pageable);
    }

    public Page<Product> searchBy(String name, Double price1,Double price2,String color,Category category,Pageable pageable){
        return productRepository.findByNameContainingAndPriceBetweenAndColorContainingAndCategory(name,price1,price2,color,category,pageable);
    }
    public Page<Product> searchBy(String name,String color,Category category,Pageable pageable){
        return productRepository.findByNameContainingAndColorContainingAndCategory(name,color,category,pageable);
    }
    public Page<Product> searchByCategory(Category category,Pageable pageable){
        return productRepository.findByCategory(category,pageable);
    }

}
