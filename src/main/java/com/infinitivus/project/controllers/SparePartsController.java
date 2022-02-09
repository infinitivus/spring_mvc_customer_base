package com.infinitivus.project.controllers;

import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.entity.person_entity.SpareParts;
import com.infinitivus.project.servace.person_service.spareparts_service.ISparePartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SparePartsController {

    @Autowired
    private ISparePartsService sparePartsService;

    @RequestMapping(value = "/showAllSpareParts")
    public String showAllSpareParts(Model model) {
        List<SpareParts> allSpareParts = sparePartsService.allSpareParts();
        model.addAttribute("allParts", allSpareParts);
        SpareParts spareParts = new SpareParts();
        model.addAttribute("spareParts", spareParts);
        return "view_person/view_spareparts/show_all_spareparts";
    }

    @RequestMapping("/saveSpareParts")
    public String saveSpareParts(@Valid @ModelAttribute("spareParts") SpareParts spareParts, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "view_person/view_spareparts/show_all_spareparts";
        } else {
            sparePartsService.saveSpareParts(spareParts);
            return "redirect:/showAllSpareParts";
        }
    }

    @RequestMapping("/editSpareParts")
    public String editSpareParts(@RequestParam("partsId") Integer id, Model model) {
        SpareParts spareParts = sparePartsService.getSpareParts(id);
        model.addAttribute("spareParts", spareParts);
        return "view_person/view_spareparts/edit_spareparts";
    }

    @RequestMapping("/deleteSpareParts")
    public String deleteSpareParts(@RequestParam("partsId") Integer id) {
        sparePartsService.deleteSpareParts(id);
        return "redirect:/showAllSpareParts";
    }

    @RequestMapping("/addSparePartToWork")
    public String addSparePart(@RequestParam("workId") Integer workId, Model model) {
        RepairWork repairWork = sparePartsService.getRepairWork(workId);
        model.addAttribute("repairWork", repairWork);
        List<SpareParts> spareParts = sparePartsService.allSpareParts();
        Map<Integer, String> nameSparePart = new HashMap<>();
        for (SpareParts part : spareParts) {
            nameSparePart.put(part.getId(), part.getNameSparePart());
        }
        model.addAttribute("spareParts", nameSparePart);
        model.addAttribute("partToWork", new SpareParts());
        return "view_person/view_spareparts/add_sparepart";
    }

    @RequestMapping("/assignSparePartToWork")
    public String assignSparePartToWork(@RequestParam("workId") Integer workId,
                                        @Valid @ModelAttribute("partToWork") SpareParts spareParts) {
        Integer partId = spareParts.getId();
        sparePartsService.assignPartToWork(workId, partId);
        return "redirect:/addSparePartToWork?workId=" + workId;
    }

    @RequestMapping("/unplugSparePartToWork")
    public String unplugSparePartToWork(@RequestParam("workId") Integer workId,
                                        @RequestParam("partId") Integer partId) {
        sparePartsService.unplugPartToWork(workId, partId);
        return "redirect:/addSparePartToWork?workId=" + workId;
    }
}