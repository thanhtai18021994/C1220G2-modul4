package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province,Long> {
    Page<Province> findAll(Pageable pageable);
    Page<Province> findByNameContaining(String text,Pageable pageable);
}
