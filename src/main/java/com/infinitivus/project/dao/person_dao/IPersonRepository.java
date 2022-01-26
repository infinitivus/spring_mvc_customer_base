package com.infinitivus.project.dao.person_dao;

import com.infinitivus.project.entity.person_entity.Person;

import java.util.List;

public interface IPersonRepository {

    public List<Person> getAllPerson();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);

    public List<Person> searchPerson(String searchLine);

   public List<Person> sortPerson(String sortLine);
}
