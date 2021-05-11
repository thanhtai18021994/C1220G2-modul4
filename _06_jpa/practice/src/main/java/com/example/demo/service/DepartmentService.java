package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department findById(int id);
    void save(Department department);
    void delete(Department department);
    List<Department> search(String text);
}
