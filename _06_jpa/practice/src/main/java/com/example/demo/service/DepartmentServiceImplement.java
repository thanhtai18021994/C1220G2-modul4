package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.NewTable;
import com.example.demo.repository.DepartmentAnnotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImplement implements DepartmentService{
    @Autowired
    DepartmentAnnotationRepository departmentAnnotationRepository;
    @Override
    public List<Department> findAll() {
        return departmentAnnotationRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentAnnotationRepository.getOne(id);
    }

    @Override
    public void save(Department department) {
        departmentAnnotationRepository.save(department);
    }

    @Override
    public void delete(Department department) {
        departmentAnnotationRepository.delete(department);
    }

    @Override
    public List<Department> search(String text) {
        return departmentAnnotationRepository.findByFirstnameEndsWith(text);
    }
    public List<Object> count2(){
        return departmentAnnotationRepository.findAllBy();
    }
    public List<NewTable> count(){
        List<NewTable> list=new ArrayList<>();
        for (int i = 0; i <this.count2().size(); i++) {
            if(count2().get(i)instanceof NewTable){
                list.add((NewTable) count2().get(i));
            }
        }
        return list;
    }
}
