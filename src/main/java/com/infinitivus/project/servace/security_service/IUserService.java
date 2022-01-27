package com.infinitivus.project.servace.security_service;

import com.infinitivus.project.entity.security_entity.UserData;

import java.util.List;

public interface IUserService {

    void save(UserData user);

    UserData findByUsername(String username);

      void createRoles();

    public List<UserData> listAllUser();
}
