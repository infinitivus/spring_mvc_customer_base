package com.infinitivus.project.dao.security_dao;

import com.infinitivus.project.entity.security_entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<UserRole, Long> {
}
