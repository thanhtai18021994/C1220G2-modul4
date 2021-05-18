package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    Optional<Customer> findByName(Integer id);
    Customer save(Customer customer);
    void delete(Customer customer);
}
