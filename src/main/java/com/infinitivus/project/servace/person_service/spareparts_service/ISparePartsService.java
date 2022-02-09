package com.infinitivus.project.servace.person_service.spareparts_service;

import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.entity.person_entity.SpareParts;

import java.util.List;

public interface ISparePartsService {

    List<SpareParts> allSpareParts();

    void saveSpareParts(SpareParts spareParts);

    SpareParts getSpareParts(Integer id);

    void deleteSpareParts(Integer id);

    RepairWork getRepairWork(Integer workId);

    void assignPartToWork(Integer workId, Integer partId);

    void unplugPartToWork(Integer workId, Integer partId);

}
