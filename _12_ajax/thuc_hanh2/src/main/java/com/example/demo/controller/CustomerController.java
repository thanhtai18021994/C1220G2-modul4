package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/show")
    public ResponseEntity<Iterable<Customer>> getHome(){
        Pageable pageable1= PageRequest.of(0,5);
        List<Customer> customers=customerService.findAll(pageable1).getContent();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<Iterable<Customer>> getHomePageable(@PathVariable Integer id){
        Pageable pageable1= PageRequest.of(id,5);
        List<Customer> customers=customerService.findAll(pageable1).getContent();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        Customer customer1=customerService.save(customer);
        return new ResponseEntity<>(customer1,HttpStatus.CREATED);
    }
}
