package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.impl.CustomerRepoImpliment;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplement implements CustomerService {

    @Autowired
    private CustomerRepoImpliment customerRepoImpliment;

    @Override
    public List<Customer> showAll() {
        return customerRepoImpliment.showAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepoImpliment.findById(id);
    }

    @Override
    public void save(Customer object) {
        customerRepoImpliment.save(object);
    }

    @Override
    public void update(Customer object, Long id) {

    }

    @Override
    public List<Customer> search(String text) {
        return null;
    }

    @Override
    public void remove(Long id) {
        customerRepoImpliment.remove(id);
    }
}
