package com.infinitivus.project.dao.person_dao.spareparts_dao;

import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.entity.person_entity.SpareParts;

import java.util.List;

public interface ISparePartsRepository {

    public List<SpareParts> getAllSpareParts();

    public void saveSpareParts(SpareParts spareParts);

    public SpareParts getSpareParts(int id);

    public void deleteSpareParts(int id);

    public RepairWork getRepairWork(int workId);

    public void assignPartToWork(int workId, int partId);

    public void unplugPartToWork(int workId,Integer partId);
}
