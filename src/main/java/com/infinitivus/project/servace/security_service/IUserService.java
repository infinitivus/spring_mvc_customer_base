package com.infinitivus.project.servace.security_service;

import com.infinitivus.project.entity.security_entity.UserData;
import com.infinitivus.project.entity.security_entity.UserRole;

import java.util.List;

public interface IUserService {

    void createRoles();

    boolean verificationSchema();

    void saveAdmin(UserData user);

    UserData findByUsername(String username);

    List<UserData> listAllUser();

    UserData getUser(Long id);

    List<UserRole> listRoles();

    void saveUser(UserData user);

    public void encoder(UserData user);
}
