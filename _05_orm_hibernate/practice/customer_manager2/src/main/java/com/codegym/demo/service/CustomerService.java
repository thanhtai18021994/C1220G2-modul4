package com.codegym.demo.service;

import com.codegym.demo.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface CustomerService  {
    List<Customer> findAll();
    void save (Customer customer);
    void delete(Customer customer);
    Customer findById(int id);
}
