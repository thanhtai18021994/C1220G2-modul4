package com.example.demo.service;

import java.util.List;

public interface Service<T> {
    List<T> showAll();
    T findById(Long id);
    void save(T object);
    void update(T object,Long id);
    List<T> search(String text);
    void remove(Long id);
}
