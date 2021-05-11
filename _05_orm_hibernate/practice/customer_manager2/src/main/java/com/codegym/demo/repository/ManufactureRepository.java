package com.codegym.demo.repository;

import com.codegym.demo.entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<Manufacture,Integer> {
}
