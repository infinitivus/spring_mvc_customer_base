package com.infinitivus.project.servace.security_service;

import com.infinitivus.project.entity.security_entity.UserData;
import com.infinitivus.project.entity.security_entity.UserRole;

import java.util.List;

public interface IUserService {

    void saveAdmin(UserData user);

    UserData findByUsername(String username);

    void createRoles();

    List<UserData> listAllUser();

    UserData getUser(Long id);

    List<UserRole> listRoles();

    void saveEditedUser(UserData user);

    void saveNewUser(UserData user);

     boolean verificationSchema();
}
