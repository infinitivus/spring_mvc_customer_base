package com.infinitivus.project.controller;

import com.infinitivus.project.entity.security_entity.UserData;
import com.infinitivus.project.entity.security_entity.UserRole;
import com.infinitivus.project.servace.security_service.ISecurityService;
import com.infinitivus.project.servace.security_service.IUserService;
import com.infinitivus.project.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class SecurityController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping("/")
    public String verification() {
        if (userService.verificationSchema()) {
            System.out.println("1");
            userService.createRoles();
            return "redirect:/registrationForm";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
    public String registrationForm(Model model) {
        System.out.println("2");
        model.addAttribute("adminForm", new UserData());
        return "view_security/registration_admin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("adminForm") UserData adminForm, BindingResult bindingResult, Model model) {
        userValidator.validate(adminForm, bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "view_security/registration_admin";
        }
        System.out.println("3");
        userService.saveAdmin(adminForm);
        securityService.autologin(adminForm.getUsername(), adminForm.getPasswordConfirm());
        return "redirect:/showAllPerson";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "view_security/login";
    }

    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<UserData> listUsers = userService.listAllUser();
        model.addAttribute("listUsers", listUsers);
        return "view_security/panel_admin";
    }

    @RequestMapping(value = "/adminPanel/editUser", method = RequestMethod.GET)
    public String editUser(@RequestParam("userId") Long id, Model model) {
        UserData user = userService.getUser(id);
        List<UserRole> listRoles = userService.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("role", listRoles);
        return "view_security/user_form_edit";
    }

    @RequestMapping(value = "/adminPanel/saveEditedUser", method = RequestMethod.POST)
    public String saveEditedUser(UserData user) {// при сохранении исправленного объекта добавляются роли в бд
        System.out.println(user.getRoles());
        System.out.println(user);
        userService.saveEditedUser(user);
        return "redirect:/adminPanel";
    }

    @RequestMapping("/adminPanel/addUser")
    public String addNewUser(Model model) {
        UserData addUser = new UserData();
        List<UserRole> listRoles = userService.listRoles();
        model.addAttribute("addUser", addUser);
        model.addAttribute("role", listRoles);
        return "view_security/user_form_new";
    }

    @RequestMapping(value = "/adminPanel/saveNewUser", method = RequestMethod.POST)
    public String saveNewUser(UserData user) {
        for(Object object : user.getRoles()) {

            System.out.println(object);
        }


//        Set<UserRole> werty=user.getRoles();
//        for (int i = 0; i < user.getRoles().size(); i++) {
//            System.out.println(user.getRoles(i));
//            userService.editRoles(user.getRoles(i));
//        }
//        Role roleUser = roleRepo.findByName("User");
//        Role roleCustomer = new Role(3);
//
//        user.addRole(roleUser);
//        user.addRole(roleCustomer);
        System.out.println(user.getRoles());
        System.out.println(user);
        userService.saveNewUser(user);
        return "redirect:/adminPanel";
    }

//    @RequestMapping("/addNewPersonData")
//    public String addNewPersonData(Model model) {
//        Person person = new Person();
//        model.addAttribute("person", person);
//        return "view_person/add_new_person_data";
//    }
}
