package com.example.demo.repository;

import java.util.List;

public interface Repository<T> {
    List<T> showAll();
    T findById(Long id);
    void save(T object);
    void update(T object,Long id);
    List<T> search(String text);
    void remove(Long id);
}
