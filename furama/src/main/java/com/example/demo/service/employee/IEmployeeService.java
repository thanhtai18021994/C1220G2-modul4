package com.example.demo.service.employee;

import com.example.demo.model.Division;
import com.example.demo.model.Employee;
import com.example.demo.model.Position;
import com.example.demo.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.GeneratedValue;

public interface IEmployeeService extends GeneralService<Employee> {
    Page<Employee> findByFourField(String name, String address, Position position, Division division, Pageable pageable);
    Page<Employee> findByThreeFieldP(String name,String address,Position position,Pageable pageable);
    Page<Employee> findByThreeFieldD(String name,String address,Division division,Pageable pageable);
    Page<Employee> findByTwoField(String name,String address,Pageable pageable);
}
