package com.infinitivus.project.controllers;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.servace.person_service.repairwork_service.IRepairWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RepairWorkController {

    @Autowired
    private IRepairWorkService repairWorkService;

    @RequestMapping("/addRepairWorkPerson")
    public String updateRepairWork(@RequestParam("mobileHomeId") Integer homeId, Model model) {
        MobileHome mobileHome = repairWorkService.getMobileHome(homeId);
        model.addAttribute("mobileHome", mobileHome);
        model.addAttribute("newRepairWork", new RepairWork());
        return "view_person/view_repairwork/add_repairwork";
    }

    @RequestMapping("/saveRepairWork")
    public String saveRepairWork(@RequestParam("mobileHomeId") Integer homeId,
                                 @Valid @ModelAttribute("newRepairWork") RepairWork repairWork, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return"redirect://addRepairWorkPerson?mobileHomeId="+homeId;
//            return "view_person/view_repairwork/add_repairwork";// надо придумать как со ссылкой отправить homeId
        }else
        repairWorkService.saveMobileHome(homeId, repairWork);
        return "redirect:/addRepairWorkPerson?mobileHomeId=" + homeId;
    }

    @RequestMapping("/deleteRepairWork")
    public String deleteRepairWork(@RequestParam("mobileHomeId") Integer homeId,
                                   @RequestParam("workId") Integer workId) {
        repairWorkService.deleteRepairWork(workId);
        return "redirect:/addRepairWorkPerson?mobileHomeId=" + homeId;
    }
}
