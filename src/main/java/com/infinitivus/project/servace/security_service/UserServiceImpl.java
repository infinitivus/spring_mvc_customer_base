package com.infinitivus.project.servace.security_service;

import com.infinitivus.project.dao.security_dao.IRoleRepository;
import com.infinitivus.project.dao.security_dao.IUserRepository;
import com.infinitivus.project.entity.security_entity.UserData;
import com.infinitivus.project.entity.security_entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveAdmin(UserData user) {
       UserRole roleAdmin = roleRepository.findByRole("ROLE_ADMIN");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.addRole(roleAdmin);
        userRepository.save(user);
    }

    @Override
    public UserData findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserData> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void createRoles() {
        UserRole admin = new UserRole("ROLE_ADMIN");
        UserRole master = new UserRole("ROLE_MASTER");
        UserRole manager = new UserRole("ROLE_MANAGER");
        roleRepository.save(admin);
        roleRepository.save(master);
        roleRepository.save(manager);
    }

    @Override
    public boolean verificationSchema() {
        List<UserData> allUser = userRepository.findAll();
        if (allUser.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserData getUser(Long id) {
        return userRepository.findById(id);
    }
//return userRepository.findById(id). get();



    @Override
    public List<UserRole> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void saveEditedUser(UserData user) {
        userRepository.save(user);
    }

    @Override
    public void saveNewUser(UserData user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
