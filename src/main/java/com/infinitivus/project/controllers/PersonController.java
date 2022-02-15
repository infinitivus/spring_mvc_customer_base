package com.infinitivus.project.controllers;

import com.infinitivus.project.entity.person_entity.MobileHome;
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

    //-------------------------------------------------------------
    // Не работает валидация class MobileHome. Сейчас @Pattern в MobileHome закоментированы. Пробовал создавать
    // еще одну <form:form modelAttribute в add_new_person_data.jsp, не работает. Выдает ошибку:
    //ExceptionHandlerExceptionResolver - Resolving exception from handler
    // [public java.lang.String com.infinitivus.project.controllers.PersonController.savePerson
    // (com.infinitivus.project.entity.person_entity.Person,org.springframework.validation.BindingResult)]:
    // javax.validation.ConstraintViolationException: Validation failed for classes [com.infinitivus.project.entity.person_entity.MobileHome]
    // during persist time for groups [javax.validation.groups.Default, ]
    // Предполагаю что это из-за того что я обращаюсь к классу MobileHome через поле класса Person, побороть пока не могу самостоятельно.
    // Чтобы получить ошибку надо расскоментировать @Pattern в классе MobileHome, на странице showAllPerson кликнуть Add Person,
    // заполнить поля и при сохранении выходит exception

    @RequestMapping("/addNewPersonData")
    public String addNewPersonData(Model model) {
        model.addAttribute("person",new Person());
//        model.addAttribute("mobileHome",new MobileHome());
        return "view_person/add_new_person_data";
    }

    @RequestMapping("/savePersonData")
    public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingPerson)
//                             @Valid @ModelAttribute("mobileHome") MobileHome mobileHome,BindingResult bindingMobileHome)
    {
        System.out.println(person);
//        System.out.println(mobileHome);
        if (bindingPerson.hasErrors())
//               || bindingMobileHome.hasErrors())
        {
            return "view_person/add_new_person_data";
        } else {
            iPersonService.savePerson(person);
            return "redirect:/showAllPerson";
        }
    }
//-----------------------------------------------------------------------------------------------------

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