package com.infinitivus.project.servace.security_service;

import com.infinitivus.project.entity.security_entity.UserData;

public interface ISecurityService {

    boolean verificationSchema();

    void saveAdminForm(UserData user);

    String findLoggedInUsername();

    void autologin(String username, String password);
}
