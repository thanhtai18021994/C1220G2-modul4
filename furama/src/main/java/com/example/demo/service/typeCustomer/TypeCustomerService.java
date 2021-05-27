package com.example.demo.service.typeCustomer;

import com.example.demo.model.CustomerType;
import com.example.demo.repository.ITypeCustomerREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeCustomerService implements ITypeCustomerService {
    @Autowired
    ITypeCustomerREpository customerREpository;
    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CustomerType> findAll() {
        return customerREpository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void delete(CustomerType customerType) {

    }

    @Override
    public Optional<CustomerType> findById(Integer id) {
        return Optional.empty();
    }
}
