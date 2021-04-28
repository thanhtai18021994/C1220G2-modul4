package com.example.service;

import java.util.List;

public interface CRUDservice<T> {
    List<T> findAll();
    T findById(int id);
    void save(T t);
    void delete(int id);
}
