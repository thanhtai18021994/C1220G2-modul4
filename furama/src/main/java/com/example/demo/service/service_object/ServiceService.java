package com.example.demo.service.service_object;

import com.example.demo.model.EntityService;
import com.example.demo.repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService implements IServiceService{
    @Autowired
    IServiceRepository serviceRepository;
    @Override
    public Page<EntityService> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<EntityService> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(EntityService entityService) {
        serviceRepository.save(entityService);
    }

    @Override
    public void delete(EntityService entityService) {
        serviceRepository.delete(entityService);
    }

    @Override
    public Optional<EntityService> findById(Integer id) {
        return serviceRepository.findById(id);
    }
}
