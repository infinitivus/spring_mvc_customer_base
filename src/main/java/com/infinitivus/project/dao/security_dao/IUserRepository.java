package com.infinitivus.project.dao.security_dao;

import com.infinitivus.project.entity.security_entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserData, Long> {

    UserData findByUsername(String username);

    UserData findById(Long id);
}
