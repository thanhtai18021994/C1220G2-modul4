package com.example.demo.service.customer;

import com.example.demo.model.CustomerType;
import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }
    public boolean checkEmail(String email){
        return customerRepository.existsCustomerByCustomerEmail(email);
    }
    public boolean checkPhone(String email){
        return customerRepository.existsCustomerByCustomerPhone(email);
    }
    public boolean checkCode(String email){
        return customerRepository.existsCustomerByCodeCustomer(email);
    }
    public boolean checkIdCard(String email){
        return customerRepository.existsCustomerByCustomerIdCard(email);
    }

    @Override
    public Page<Customer> findAllField(String name, String address, String phone, CustomerType customerType,Pageable pageable) {
        return customerRepository.findByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContainingAndCustomerType(name, address, phone, customerType,pageable);
    }

    @Override
    public Page<Customer> findByNameAndAddressAndPhone(String name, String address, String phone,Pageable pageable) {
        return customerRepository.findByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContaining(name,address,phone,pageable);
    }
}
