package com.infinitivus.project.servace.person_service.spareparts_service;

import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.entity.person_entity.SpareParts;

import java.util.List;

public interface ISparePartsService {

    public List<SpareParts> allSpareParts();

    public void saveSpareParts(SpareParts spareParts);

    public SpareParts getSpareParts(int id);

    public void deleteSpareParts(int id);

    public RepairWork getRepairWork(int workId);

    public void assignPartToWork(int workId, int partId);

    public void unplugPartToWork(int workId,Integer partId);

}
