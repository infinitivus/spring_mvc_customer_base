package com.infinitivus.project.dao.person_dao.spareparts_dao;

import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.entity.person_entity.SpareParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Repository
public class SparePartsRepositoryImpl implements ISparePartsRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SpareParts> getAllSpareParts() {
        Query query = entityManager.createQuery("from SpareParts", SpareParts.class);
        List<SpareParts> allSpareParts = query.getResultList();
        return allSpareParts;
    }

    @Override
    public void saveSpareParts(SpareParts spareParts) {
        entityManager.merge(spareParts);
    }

    @Override
    public SpareParts getSpareParts(Integer id) {
        SpareParts spareParts = entityManager.find(SpareParts.class, id);
        return spareParts;
    }

    @Override
    public void deleteSpareParts(Integer id) {
        SpareParts spareParts = getSpareParts(id);
        entityManager.remove(spareParts);
    }

    @Override
    public RepairWork getRepairWork(Integer workId) {
        return entityManager.find(RepairWork.class, workId);
    }

    @Override
    public void assignPartToWork(Integer workId, Integer partId) {
        RepairWork repairWork = getRepairWork(workId);
        SpareParts spareParts = getSpareParts(partId);
        repairWork.addSparePartsToRepairWork(spareParts);
        entityManager.merge(repairWork);
    }

    @Override
    public void unplugPartToWork(Integer workId, Integer partId) {
        SpareParts spareParts = getSpareParts(partId);
        RepairWork repairWork = getRepairWork(workId);
        List<SpareParts> listPartsToWork = repairWork.getSparePartsList();
        Iterator<SpareParts> iterator = listPartsToWork.iterator();
        while (iterator.hasNext()) {
            SpareParts sp = iterator.next();
            if (sp.equals(spareParts)) {
                iterator.remove();
            }
        }
        entityManager.merge(repairWork);
    }
}

