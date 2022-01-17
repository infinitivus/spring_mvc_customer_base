package com.infinitivus.project.dao;

import com.infinitivus.project.entity.MobileHome;
import com.infinitivus.project.entity.Person;
import com.infinitivus.project.entity.RepairWork;
import com.infinitivus.project.entity.SpareParts;

import java.util.List;

public interface IPersonDAO {

    public List<Person> getAllPerson();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);

    public List<Person> searchPerson(String searchLine);

   public List<Person> sortPerson(String sortLine);

   public boolean verificationSchema();
}
