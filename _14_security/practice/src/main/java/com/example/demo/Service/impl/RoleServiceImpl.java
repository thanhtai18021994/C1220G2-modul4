package com.example.demo.Service.impl;

import com.example.demo.Service.RoleService;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleResponsitory roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByNameRole(name);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
