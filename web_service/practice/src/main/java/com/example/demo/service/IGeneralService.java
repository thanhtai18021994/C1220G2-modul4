package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Integer id);
    T save(T t);
    void remove(T t);
}
