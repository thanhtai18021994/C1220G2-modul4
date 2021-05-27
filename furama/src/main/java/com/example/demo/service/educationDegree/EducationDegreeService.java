package com.example.demo.service.educationDegree;

import com.example.demo.model.EducationDegree;
import com.example.demo.repository.IEducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationDegreeService implements IEducationDegreeService{
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Override
    public Page<EducationDegree> findAll(Pageable pageable) {
        return educationDegreeRepository.findAll(pageable);
    }

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void delete(EducationDegree educationDegree) {
        educationDegreeRepository.delete(educationDegree);
    }

    @Override
    public Optional<EducationDegree> findById(Integer id) {
        return educationDegreeRepository.findById(id);
    }
}
