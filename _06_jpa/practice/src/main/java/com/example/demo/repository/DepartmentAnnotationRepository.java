package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.NewTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DepartmentAnnotationRepository extends JpaRepository<Department,Integer> {
    @Query("select department from Department department where department.name = ?1")
    Department findByName(String departmentName);

    @Query("select department from Department department where department.name like %?1%")
    List<Department> findByFirstnameEndsWith2(String departmentName);

    @Query(value = "select department from Department department where department.name = ?1", nativeQuery = true)
    Department findByName2(String departmentName);
    @Transactional
    @Query(value = "call getAll(?1)",nativeQuery = true)
    List<Department> findByFirstnameEndsWith(String departmentName);
    @Query(value = "select name,count(name) from deparment group by name", nativeQuery = true)
    List<Object> findAllBy();
}
