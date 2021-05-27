package com.example.demo.service.customer;

import com.example.demo.model.CustomerType;
import com.example.demo.model.Customer;
import com.example.demo.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends GeneralService<Customer> {
    Page<Customer> findAllField(String name, String address, String phone, CustomerType customerType, Pageable pageable);
    Page<Customer> findByNameAndAddressAndPhone(String name,String address,String phone,Pageable pageable);
}
