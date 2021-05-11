package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    Page<T> search(String text, Pageable pageable);
    Optional<T> findById(Integer id);
    void save(T object);
    void delete(T object);
}
