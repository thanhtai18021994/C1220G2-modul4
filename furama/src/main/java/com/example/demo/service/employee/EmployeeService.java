package com.example.demo.service.employee;

import com.example.demo.model.Division;
import com.example.demo.model.Employee;
import com.example.demo.model.Position;
import com.example.demo.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> findByFourField(String name, String address, Position position, Division division,Pageable pageable) {
        return employeeRepository.findByEmployeeNameContainingAndEmployeeAddressContainingAndPositionAndDivision(name,address,position,division,pageable);
    }

    @Override
    public Page<Employee> findByThreeFieldP(String name, String address, Position position,Pageable pageable) {
        return employeeRepository.findByEmployeeNameContainingAndEmployeeAddressContainingAndPosition(name, address, position, pageable);
    }

    @Override
    public Page<Employee> findByThreeFieldD(String name, String address, Division division, Pageable pageable) {
        return employeeRepository.findByEmployeeNameContainingAndEmployeeAddressContainingAndDivision(name, address, division, pageable);
    }

    @Override
    public Page<Employee> findByTwoField(String name, String address,Pageable pageable) {
        return employeeRepository.findByEmployeeNameContainingAndEmployeeAddressContaining(name, address, pageable);
    }
}
