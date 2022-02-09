package com.infinitivus.project.controllers;

import com.infinitivus.project.entity.person_entity.Person;
import com.infinitivus.project.servace.person_service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping(value = {"/showAllPerson"})
    public String showAllPerson(Model model) {
        List<Person> allPerson = iPersonService.allPerson();
        model.addAttribute("allPers", allPerson);
        return "view_person/show_all_person";
    }

    @RequestMapping("/addNewPersonData")
    public String addNewPersonData(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "view_person/add_new_person_data";
    }

    @RequestMapping("/savePersonData")
    public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "view_person/add_new_person_data";
        }
        System.out.println("cont" + person);
        iPersonService.savePerson(person);
        return "redirect:/showAllPerson";
    }

    @RequestMapping("/fullInfoPerson")
    public String fullInfoPerson(@RequestParam("infoPersId") Integer id, Model model) {
        Person person = iPersonService.getPerson(id);
        model.addAttribute("pers", person);
        return "view_person/full_info_person";
    }

    @RequestMapping("/updateInfoPerson")
    public String updatePerson(@RequestParam("infoPersId") Integer id, Model model) {
        Person person = iPersonService.getPerson(id);
        model.addAttribute("person", person);
        return "view_person/add_new_person_data";
    }

    @RequestMapping("/deleteInfoPerson")
    public String deletePerson(@RequestParam("infoPersId") Integer id) {
        iPersonService.deletePerson(id);
        return "redirect:/showAllPerson";
    }

    @RequestMapping("/searchPerson")
    public String searchPerson(@RequestParam("search") String searchLine, Model model) {
        List<Person> searchListPerson = iPersonService.searchPerson(searchLine);
        model.addAttribute("allPers", searchListPerson);
        return "view_person/show_all_person";
    }

    @RequestMapping("/sortPerson")
    public String sortPerson(@RequestParam("select") String sortLine, Model model) {
        List<Person> sortListPerson = iPersonService.sortPerson(sortLine);
        model.addAttribute("allPers", sortListPerson);
        return "view_person/show_all_person";
    }
}