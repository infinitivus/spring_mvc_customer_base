package com.infinitivus.project.servace.person_service.repairwork_service;

import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;

import java.util.List;

public interface IRepairWorkService {

    List<RepairWork> allRepairWork();

    void saveRepairWork(RepairWork repairWork);

    RepairWork getRepairWork(Integer id);

    void deleteRepairWork(Integer id);

    MobileHome getMobileHome(Integer id);

    void saveMobileHome(Integer id, RepairWork repairWork);
}
