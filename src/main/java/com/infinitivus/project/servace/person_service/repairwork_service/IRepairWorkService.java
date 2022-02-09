package com.infinitivus.project.servace.person_service.repairwork_service;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;

import java.util.List;

public interface IRepairWorkService {

    public List<RepairWork> allRepairWork();

    public void saveRepairWork(RepairWork repairWork);

    public RepairWork getRepairWork(Integer id);

    public void deleteRepairWork(Integer id);

    public MobileHome getMobileHome(Integer id);

    public void saveMobileHome(Integer id,RepairWork repairWork);
}
