package com.infinitivus.project.servace.person_service.repairwork_service;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;

import java.util.List;

public interface IRepairWorkService {

    public List<RepairWork> allRepairWork();

    public void saveRepairWork(RepairWork repairWork);

    public RepairWork getRepairWork(int id);

    public void deleteRepairWork(int id);

    public MobileHome getMobileHome(int id);

    public void saveMobileHome(int id,RepairWork repairWork);
}
