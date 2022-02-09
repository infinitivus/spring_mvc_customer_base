package com.infinitivus.project.servace.person_service;

import com.infinitivus.project.dao.person_dao.IPersonRepository;
import com.infinitivus.project.entity.person_entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    @Transactional
    public List<Person> allPerson() {
        return iPersonRepository.getAllPerson();
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        iPersonRepository.savePerson(person);
    }

    @Override
    @Transactional
    public Person getPerson(Integer id) {
        return iPersonRepository.getPerson(id);

    }

    @Override
    @Transactional
    public void deletePerson(Integer id) {
        iPersonRepository.deletePerson(id);
    }

    @Override
    @Transactional
    public List<Person> searchPerson(String searchLine) {
        return iPersonRepository.searchPerson(searchLine);
    }

    @Override
    @Transactional
    public List<Person> sortPerson(String sortLine) {
        return iPersonRepository.sortPerson(sortLine);
    }
}
