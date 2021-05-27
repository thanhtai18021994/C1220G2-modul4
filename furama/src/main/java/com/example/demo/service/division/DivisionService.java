package com.example.demo.service.division;

import com.example.demo.model.Division;
import com.example.demo.repository.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public Page<Division> findAll(Pageable pageable) {
        return divisionRepository.findAll(pageable);
    }

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void delete(Division division) {
        divisionRepository.delete(division);
    }

    @Override
    public Optional<Division> findById(Integer id) {
        return divisionRepository.findById(id);
    }
}
