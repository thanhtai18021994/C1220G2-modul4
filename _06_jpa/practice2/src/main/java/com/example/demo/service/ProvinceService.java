package com.example.demo.service;

import com.example.demo.entity.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> showAll();
    Province findById(Long id);
    void save(Province province);
    void delete(Province province);
}
