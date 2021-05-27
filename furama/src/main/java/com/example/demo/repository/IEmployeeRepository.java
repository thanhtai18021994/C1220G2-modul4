package com.example.demo.repository;

import com.example.demo.model.Division;
import com.example.demo.model.Employee;
import com.example.demo.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findByEmployeeNameContainingAndEmployeeAddressContainingAndPositionAndDivision(String name, String address, Position position, Division division, Pageable pageable);
    Page<Employee> findByEmployeeNameContainingAndEmployeeAddressContainingAndPosition(String name, String address, Position position, Pageable pageable);
    Page<Employee> findByEmployeeNameContainingAndEmployeeAddressContainingAndDivision(String name, String address, Division division, Pageable pageable);
    Page<Employee> findByEmployeeNameContainingAndEmployeeAddressContaining(String name, String address, Pageable pageable);
}
