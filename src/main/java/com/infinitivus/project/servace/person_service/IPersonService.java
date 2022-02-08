package com.infinitivus.project.servace.person_service;

import com.infinitivus.project.entity.person_entity.Person;

import java.util.List;

public interface IPersonService {

    public List<Person> allPerson();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);

    public List<Person> searchPerson(String searchLine);

    public List<Person> sortPerson(String sortLine);
}
