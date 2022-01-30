package com.infinitivus.project.servace.security_service;

public interface ISecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
