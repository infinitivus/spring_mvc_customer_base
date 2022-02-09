package com.infinitivus.project.dao.person_dao.repairwork_dao;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;

import java.util.List;

public interface IRepairWorkRepository {

    List<RepairWork> getAllRepairWork();

    void saveRepairWork(RepairWork repairWork);

    RepairWork getRepairWork(Integer id);

    void deleteRepairWork(Integer id);

    MobileHome getMobileHome(Integer id);

    void saveMobileHome(Integer id, RepairWork repairWork);
}
