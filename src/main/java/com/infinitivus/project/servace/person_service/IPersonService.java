package com.infinitivus.project.servace.person_service;

import com.infinitivus.project.entity.person_entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> allPerson();

    void savePerson(Person person);

    Person getPerson(Integer id);

    void deletePerson(Integer id);

    List<Person> searchPerson(String searchLine);

    List<Person> sortPerson(String sortLine);
}
