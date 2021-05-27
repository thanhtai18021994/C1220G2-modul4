package com.example.demo.repository;

import com.example.demo.model.EntityService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<EntityService,Integer> {
}
