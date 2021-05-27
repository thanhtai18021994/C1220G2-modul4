package com.example.demo.service.rentType;

import com.example.demo.model.RentType;
import com.example.demo.repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeRepository;
    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return rentTypeRepository.findAll(pageable);
    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void delete(RentType rentType) {
        rentTypeRepository.delete(rentType);
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return rentTypeRepository.findById(id);
    }
}
