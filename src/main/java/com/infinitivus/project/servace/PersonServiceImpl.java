package com.infinitivus.project.servace;

import com.infinitivus.project.dao.IPersonDAO;
import com.infinitivus.project.entity.MobileHome;
import com.infinitivus.project.entity.Person;
import com.infinitivus.project.entity.RepairWork;
import com.infinitivus.project.entity.SpareParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDAO iPersonDAO;

    @Override
    @Transactional
    public List<Person> allPerson() {
        return iPersonDAO.getAllPerson();
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        iPersonDAO.savePerson(person);
    }

    @Override
    @Transactional
    public Person getPerson(int id) {
        return iPersonDAO.getPerson(id);

    }

    @Override
    @Transactional
    public void deletePerson(int id) {
        iPersonDAO.deletePerson(id);
    }

    @Override
    @Transactional
    public List<Person> searchPerson(String searchLine) {
        return iPersonDAO.searchPerson(searchLine);
    }

    @Override
    @Transactional
    public List<Person> sortPerson(String sortLine) {
        return iPersonDAO.sortPerson(sortLine);
    }

    @Override
    @Transactional
    public boolean verificationSchema() {
        return iPersonDAO.verificationSchema();
    }
}
