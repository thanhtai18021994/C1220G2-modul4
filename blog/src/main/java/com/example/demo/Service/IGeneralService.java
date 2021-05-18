package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    Optional<T> findById(Integer id);
    void save(T t);
    void delete(T t);
    T saveR(T t);

}
