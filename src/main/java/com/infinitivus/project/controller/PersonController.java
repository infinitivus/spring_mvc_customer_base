package com.infinitivus.project.controller;

import com.infinitivus.project.entity.person_entity.Person;
import com.infinitivus.project.servace.person_servace.IPersonService;
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
        } else {
//            System.out.println("Save Cont -> DAO : " + person + person.getMobileHome() + person.getMobileHome().getRepairWorkList());///////////////////////////////////////////
            // при редактировании person - редактируется и записывается со своим id, а mobaleHome записывается новая в бд
            iPersonService.savePerson(person);
            return "redirect:/showAllPerson";
        }
    }

    @RequestMapping("/fullInfoPerson")
    public String fullInfoPerson(@RequestParam("infoPersId") int id, Model model) {
        Person person = iPersonService.getPerson(id);
        model.addAttribute("pers", person);
        return "view_person/full_info_person";
    }

    @RequestMapping("/updateInfoPerson")
    public String updatePerson(@RequestParam("infoPersId") int id, Model model) {
        Person person = iPersonService.getPerson(id);
        model.addAttribute("person", person);
    //    System.out.println("Read Dao -> Cont : " + person + person.getMobileHome() + person.getMobileHome().getRepairWorkList());///////////////////////////////////////////
        return "view_person/add_new_person_data";
    }

    @RequestMapping("/updateInfoRepair")
    public String updateRepair(@RequestParam("infoPersId") int id, Model model) {
        return "view_person/add_new_person_data";
    }

    @RequestMapping("/deleteInfoPerson")
    public String deletePerson(@RequestParam("infoPersId") int id) {
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