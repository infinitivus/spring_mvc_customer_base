package com.infinitivus.project.dao.person_dao;

import com.infinitivus.project.entity.person_entity.Person;

import java.util.List;

public interface IPersonRepository {

    List<Person> getAllPerson();

    void savePerson(Person person);

    Person getPerson(Integer id);

    void deletePerson(Integer id);

    List<Person> searchPerson(String searchLine);

    List<Person> sortPerson(String sortLine);
}
