package com.infinitivus.project.controller;

import com.infinitivus.project.entity.security_entity.UserData;
import com.infinitivus.project.servace.security_service.ISecurityService;
import com.infinitivus.project.servace.security_service.IUserService;
import com.infinitivus.project.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SecurityController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        userService.createRoles();
        model.addAttribute("userForm", new UserData());
        return "registration_admin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserData userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration_admin";
        }
        System.out.println(userForm);
        System.out.println(userForm.getRoles() + userForm.getUsername() + userForm.getPassword());

        userService.save(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
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

    @RequestMapping(value="/adminPanel",method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<UserData> listUsers = userService.listAllUser();
        model.addAttribute("listUsers", listUsers);
        return "view_security/panel_admin";
    }

//    @RequestMapping(value = {"/", "/showAllPerson"}, method = RequestMethod.GET)
//    public String welcome(Model model) {
//        return "sho";
//    }
}
