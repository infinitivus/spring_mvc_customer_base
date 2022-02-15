package com.infinitivus.project.dao.security_dao;

import com.infinitivus.project.entity.security_entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query("SELECT r FROM UserRole r WHERE r.role = ?1")
    UserRole findByRole(String role);
}
