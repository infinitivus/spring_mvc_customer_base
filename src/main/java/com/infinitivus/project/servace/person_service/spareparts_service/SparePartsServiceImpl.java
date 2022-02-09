package com.infinitivus.project.servace.person_service.spareparts_service;

import com.infinitivus.project.dao.person_dao.spareparts_dao.ISparePartsRepository;
import com.infinitivus.project.entity.person_entity.RepairWork;
import com.infinitivus.project.entity.person_entity.SpareParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SparePartsServiceImpl implements ISparePartsService {

    @Autowired
    private ISparePartsRepository sparePartsRepository;

    @Override
    @Transactional
    public List<SpareParts> allSpareParts() {
        return sparePartsRepository.getAllSpareParts();
    }

    @Override
    @Transactional
    public void saveSpareParts(SpareParts spareParts) {
        sparePartsRepository.saveSpareParts(spareParts);
    }

    @Override
    @Transactional
    public SpareParts getSpareParts(Integer id) {
        return sparePartsRepository.getSpareParts(id);
    }

    @Override
    @Transactional
    public void deleteSpareParts(Integer id) {
        sparePartsRepository.deleteSpareParts(id);
    }

    @Override
    @Transactional
    public RepairWork getRepairWork(Integer workId) {
        return sparePartsRepository.getRepairWork(workId);
    }

    @Override
    @Transactional
    public void assignPartToWork(Integer workId, Integer partId) {
        sparePartsRepository.assignPartToWork(workId, partId);
    }

    @Override
    @Transactional
    public void unplugPartToWork(Integer workId, Integer partId) {
        sparePartsRepository.unplugPartToWork(workId, partId);
    }


}
