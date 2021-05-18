package com.example.demo.service;

import com.example.demo.model.SmartPhone;
import com.example.demo.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneService implements ISmartPhoneService{
    @Autowired
    ISmartPhoneRepository smartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
       return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void delete(SmartPhone smartPhone) {
      smartPhoneRepository.delete(smartPhone);
    }
}
