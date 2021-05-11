package com.example.demo.services.provinceService;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Province;
import com.example.demo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceimplement implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> showList() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.getOne(id);
    }

    @Override
    public void save(Province object) {
        provinceRepository.save(object);
    }

    @Override
    public void delete(Province object) {
        provinceRepository.delete(object);
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Page<Province> search(String string, Pageable pageable) {
        return provinceRepository.findByNameContaining(string,pageable);
    }
}
