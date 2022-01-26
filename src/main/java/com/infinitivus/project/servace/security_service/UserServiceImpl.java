package com.infinitivus.project.servace.security_service;


import com.infinitivus.project.dao.security_dao.IRoleRepository;
import com.infinitivus.project.dao.security_dao.IUserRepository;
import com.infinitivus.project.entity.security_entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserData user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public UserData findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
