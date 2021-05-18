package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service<T> {
    Page<T> showAll(Pageable pageable);
    Optional<T> findById(Integer id);
}
