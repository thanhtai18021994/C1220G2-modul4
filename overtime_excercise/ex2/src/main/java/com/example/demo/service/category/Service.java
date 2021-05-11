package com.example.demo.service.category;

import org.springframework.data.domain.Page;

import java.util.List;

public interface Service<T> {
    Page<T> findAll(Integer num1);
    List<T> search(String text,Integer num1,Integer num2);
    T findById(Integer id);
    void save(T object);
    void delete(T object);
}
