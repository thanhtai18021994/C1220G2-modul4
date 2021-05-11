package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> showAll();
    Customer findById(Long id);
    void save(Customer customer);
    void delete(Customer customer);
}
