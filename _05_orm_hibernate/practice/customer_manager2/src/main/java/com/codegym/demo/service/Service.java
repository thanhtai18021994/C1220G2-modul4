package com.codegym.demo.service;

import java.util.List;

public interface Service<T> {
    List<T> showList();
    T findById(Integer id);
    void save(T object);
}
