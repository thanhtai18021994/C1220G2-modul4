package com.example.demo.services;

import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<T>{
    List<T> showList();
    T findById(Long id);
    void save(T object);
    void delete(T object);
    Page<T> findAll(Pageable pageable);
    Page<T> search(String string,Pageable pageable);
}
