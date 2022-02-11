package com.infinitivus.project.servace.security_service;

import com.infinitivus.project.entity.security_entity.UserData;

import java.util.List;

public interface IUserService {

    void createRoles();

    boolean verificationSchema();

    void saveAdmin(UserData user);

    UserData findByUsername(String username);

    List<UserData> listAllUser();

    UserData getUser(Long id);

    void saveUser(UserData user, String userRole);

    void encoder(UserData user);

    void deleteUser(Long id);
}
