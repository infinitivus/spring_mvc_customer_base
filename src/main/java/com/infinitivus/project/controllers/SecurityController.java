package com.infinitivus.project.controllers;

import com.infinitivus.project.entity.security_entity.UserData;
import com.infinitivus.project.entity.security_entity.UserRole;
import com.infinitivus.project.servace.security_service.ISecurityService;
import com.infinitivus.project.servace.security_service.IUserService;
import com.infinitivus.project.servace.security_service.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return "redirect:/registrationForm";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
    public String registrationForm(Model model) {
        model.addAttribute("adminForm", new UserData());
        return "view_security/registration_admin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("adminForm") UserData adminForm, BindingResult bindingResult, Model model) {
        userValidator.validate(adminForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "view_security/registration_admin";
        }
        userService.createRoles();
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
        UserData editUser = userService.getUser(id);
        model.addAttribute("userForm", editUser);
        model.addAttribute("userRole", new UserRole());
        return "view_security/user_form_edit";
    }

    @RequestMapping(value = "/adminPanel/saveEditedUser", method = RequestMethod.POST)
    public String saveEditedUser(@ModelAttribute("userForm") UserData userForm, BindingResult bindingResult,
                                 @ModelAttribute("userRole") UserRole userRole) {
        userForm.clearRole();
        userService.saveUser(userForm,userRole.getRole());
        return "redirect:/adminPanel";
    }

    @RequestMapping(value = "/adminPanel/addUser", method = RequestMethod.GET)
    public String addNewUser(Model model) {
        model.addAttribute("userForm", new UserData());
        model.addAttribute("userRole", new UserRole());
        return "view_security/user_form_new";
    }

    @RequestMapping(value = "/adminPanel/saveNewUser", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("userForm") UserData userForm, BindingResult bindingResult,
                              @ModelAttribute("userRole") UserRole userRole) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "view_security/user_form_new";
        } else {
            userService.encoder(userForm);
            userService.saveUser(userForm,userRole.getRole());
            return "redirect:/adminPanel";
        }
    }

    @RequestMapping(value = "/adminPanel/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id){
        userService.deleteUser(id);
        System.out.println(id);//////////////////////////////////////////
        return "redirect:/adminPanel";
    }
}
