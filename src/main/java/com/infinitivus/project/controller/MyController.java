package com.infinitivus.project.controller;

import com.infinitivus.project.entity.*;
import com.infinitivus.project.servace.IPersonService;
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
public class MyController {

    @Autowired
    private IPersonService iPersonService;

//    @RequestMapping("/")
//    public String verificationExistenceSchema(){
//        boolean verification=iPersonService.verificationSchema();
//        if(verification){
//            return "input_password";
//        }
//        return "initial_settings";
//    }

    @RequestMapping("/")
    public String showAllPerson(Model model) { // Получение и вывод на экран всех клиентов
        List<Person> allPerson = iPersonService.allPerson();
        model.addAttribute("allPers", allPerson);
        return "show_all_person";
    }

    @RequestMapping("/addNewPersonData") // Создание нового клиента и вывод таблицы для заполнения информации
    public String addNewPersonData(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        MobileHome mobileHome = new MobileHome();
        model.addAttribute("mobileHome", mobileHome);
        RepairWork repairWork = new RepairWork();
        model.addAttribute("repair", repairWork);
        return "add_new_person_data";
    }

    @RequestMapping("/savePersonData")
    // запись информации о новом клиенте в базу и возврат стартовой страницы с новой инфо
//    public String savePerson(@Valid @ModelAttribute("person") Person person,
//                             @ModelAttribute("mobileHome") MobileHome home,
//                             @ModelAttribute("repairWork") RepairWork work,
//                             BindingResult bindingResult) {
    public String savePerson(@Valid @ModelAttribute("formAllEntity") FormAllEntity formAllEntity,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_new_person_data";
        } else {
            Person person = new Person();
            MobileHome mobileHome = person.getMobileHome();
            List<RepairWork> repairWorkList = mobileHome.getRepairWorkList();
            iPersonService.savePerson(person, mobileHome, repairWorkList);
            return "redirect:/";
        }
    }

    @RequestMapping("/fullInfoPerson") // отдельный вывод полной информации о клиенте
    public String fullInfoPerson(@RequestParam("infoPersId") int id, Model model) {
        Person person = iPersonService.getPerson(id);
        MobileHome mobileHome = person.getMobileHome();
        List<RepairWork> repairWorksList = mobileHome.getRepairWorkList();

        model.addAttribute("pers", person);
        model.addAttribute("home", mobileHome);
        model.addAttribute("work", repairWorksList);
        return "full_info_person";
    }

    @RequestMapping("/updateInfoPerson") // исправление информации о клиенте
    public String updatePerson(@RequestParam("infoPersId") int id, Model model) {
        System.out.println("update info pers id " + id);////////////////////////////////////
        Person person = iPersonService.getPerson(id);
        MobileHome mobileHome = person.getMobileHome();
        //   RepairWork repairWork=new RepairWork();
        List<RepairWork> repairWorksList = mobileHome.getRepairWorkList(); ///////////////////////////////////
        model.addAttribute("person", person);
        model.addAttribute("home", mobileHome);
        model.addAttribute("repair", repairWorksList);


        System.out.println("Controller " + repairWorksList);//////////////////////////////////////////
        //     System.out.println("Controller "+ sparePartsList);/////////////////////////////////////////
        return "add_new_person_data";
    }

    @RequestMapping("/deleteInfoPerson") // удаление информации о клиенте ... не работает
    public String deletePerson(@RequestParam("infoPersId") int id) {
        iPersonService.deletePerson(id);
        return "redirect:/";
    }

    @RequestMapping("/searchPerson")
    public String searchPerson(@RequestParam("search") String searchLine, Model model) {
        List<Person> searchListPerson = iPersonService.searchPerson(searchLine);
        model.addAttribute("allPers", searchListPerson);
        return "show_all_person";
    }

    @RequestMapping("/sortPerson")
    public String sortPerson(@RequestParam("select") String sortLine, Model model) {
        List<Person> sortListPerson = iPersonService.sortPerson(sortLine);
        model.addAttribute("allPers", sortListPerson);
        return "show_all_person";
    }
}