package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.customer.CustomerService;
import com.example.demo.service.customer.ICustomerServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    ICustomerServie customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll(){
        List<Customer> customers= (List<Customer>) customerService.findAll();
        if(customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(customers,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id){
        Optional<Customer> customer=customerService.findById(id);
        if(customer.isPresent()){
            return new ResponseEntity<>(customer.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
        Optional<Customer> customerOptional=customerService.findById(id);
        if(!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }
}
