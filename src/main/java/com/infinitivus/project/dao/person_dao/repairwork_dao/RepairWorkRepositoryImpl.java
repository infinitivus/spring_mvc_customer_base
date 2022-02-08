package com.infinitivus.project.dao.person_dao.repairwork_dao;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RepairWorkRepositoryImpl implements IRepairWorkRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<RepairWork> getAllRepairWork() {
        Query query = entityManager.createQuery("from RepairWork", RepairWork.class);
        List<RepairWork> allRepairWork = query.getResultList();
        return allRepairWork;
    }

    @Override
    public void saveRepairWork(RepairWork repairWork) {
        entityManager.merge(repairWork);
    }

    @Override
    public RepairWork getRepairWork(int id) {
        RepairWork repairWork = entityManager.find(RepairWork.class, id);
        return repairWork;
    }

    @Override
    public void deleteRepairWork(int id) {
        Query query = entityManager.createQuery("delete from RepairWork r where r.id = :id");
                query.setParameter("id", id).executeUpdate();
    }

    @Override
    public MobileHome getMobileHome(int id) {
        MobileHome mobileHome = entityManager.find(MobileHome.class, id);
        return mobileHome;
    }

    @Override
    public void saveMobileHome(int id, RepairWork repairWork) {
        MobileHome getMobileHome = entityManager.find(MobileHome.class, id);
        getMobileHome.addRepairWorkToMobileHome(repairWork);
        entityManager.merge(getMobileHome);
    }
}
