package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleResponsitory extends JpaRepository<Role,Long> {
    Role findByNameRole(String role_admin);
}
