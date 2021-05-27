package com.example.demo.repository;

import com.example.demo.model.CustomerType;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
Boolean existsCustomerByCustomerEmail(String email);
Page<Customer> findByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContainingAndCustomerType(String name, String address, String phone, CustomerType customerType,Pageable pageable);
Page<Customer> findByCustomerNameContainingAndCustomerAddressContainingAndCustomerPhoneContaining(String name,String address,String phone,Pageable pageable);
boolean existsCustomerByCustomerIdCard(String idCard);
boolean existsCustomerByCustomerPhone(String phone);
boolean existsCustomerByCodeCustomer(String code);
}
