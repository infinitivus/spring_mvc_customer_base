package com.infinitivus.project.dao.person_dao.repairwork_dao;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class RepairWorkRepositoryImpl implements IRepairWorkRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void deleteRepairWork(Integer id) {
        Query query = entityManager.createQuery("delete from RepairWork r where r.id = :id");
        query.setParameter("id", id).executeUpdate();
    }

    @Override
    public MobileHome getMobileHome(Integer id) {
        MobileHome mobileHome = entityManager.find(MobileHome.class, id);
        return mobileHome;
    }

    @Override
    public void saveMobileHome(Integer id, RepairWork repairWork) {
        MobileHome getMobileHome = entityManager.find(MobileHome.class, id);
        getMobileHome.addRepairWorkToMobileHome(repairWork);
        entityManager.merge(getMobileHome);
    }
}
