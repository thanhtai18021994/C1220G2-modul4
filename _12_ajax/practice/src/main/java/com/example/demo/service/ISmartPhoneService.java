package com.example.demo.service;

import com.example.demo.model.SmartPhone;

import java.util.List;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone smartPhone);
    void delete(SmartPhone smartPhone);
}
