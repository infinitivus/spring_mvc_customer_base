package com.infinitivus.project.servace.person_service.repairwork_service;

import com.infinitivus.project.dao.person_dao.repairwork_dao.IRepairWorkRepository;
import com.infinitivus.project.entity.person_entity.MobileHome;
import com.infinitivus.project.entity.person_entity.RepairWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepairWorkServiceImpl implements IRepairWorkService {

    @Autowired
    private IRepairWorkRepository repairWorkRepository;

    @Override
    @Transactional
    public void deleteRepairWork(Integer id) {
        repairWorkRepository.deleteRepairWork(id);
    }

    @Override
    @Transactional
    public MobileHome getMobileHome(Integer id) {
        return repairWorkRepository.getMobileHome(id);
    }

    @Override
    @Transactional
    public void saveMobileHome(Integer id, RepairWork repairWork) {
        repairWorkRepository.saveMobileHome(id, repairWork);
    }
}
