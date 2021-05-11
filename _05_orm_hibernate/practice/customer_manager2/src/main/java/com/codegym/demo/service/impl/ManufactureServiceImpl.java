package com.codegym.demo.service.impl;

import com.codegym.demo.entity.Manufacture;
import com.codegym.demo.repository.ManufactureRepository;
import com.codegym.demo.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    private ManufactureRepository manufactureRepository;
    @Override
    public List<Manufacture> findAll() {
        return manufactureRepository.findAll();
    }
}
