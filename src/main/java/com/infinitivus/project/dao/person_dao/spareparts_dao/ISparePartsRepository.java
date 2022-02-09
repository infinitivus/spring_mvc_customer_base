package com.infinitivus.project.dao.person_dao.spareparts_dao;

import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.entity.person_entity.SpareParts;

import java.util.List;

public interface ISparePartsRepository {

    List<SpareParts> getAllSpareParts();

    void saveSpareParts(SpareParts spareParts);

    SpareParts getSpareParts(Integer id);

    void deleteSpareParts(Integer id);

    RepairWork getRepairWork(Integer workId);

    void assignPartToWork(Integer workId, Integer partId);

    void unplugPartToWork(Integer workId, Integer partId);
}
