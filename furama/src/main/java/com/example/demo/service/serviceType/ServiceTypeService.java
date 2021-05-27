package com.example.demo.service.serviceType;

import com.example.demo.model.ServiceType;
import com.example.demo.repository.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;
    @Override
    public Page<ServiceType> findAll(Pageable pageable) {
        return serviceTypeRepository.findAll(pageable);
    }

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void delete(ServiceType serviceType) {
        serviceTypeRepository.delete(serviceType);
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return serviceTypeRepository.findById(id);
    }
}
