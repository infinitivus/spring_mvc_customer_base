package com.infinitivus.project.dao.person_dao.repairwork_dao;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;

import java.util.List;

public interface IRepairWorkRepository {

    public List<RepairWork> getAllRepairWork();

    public void saveRepairWork(RepairWork repairWork);

    public RepairWork getRepairWork(int id);

    public void deleteRepairWork(int id);

    public MobileHome getMobileHome(int id);

    public void saveMobileHome(int id,RepairWork repairWork);
}
