package com.infinitivus.project.servace;

import com.infinitivus.project.entity.MobileHome;
import com.infinitivus.project.entity.Person;
import com.infinitivus.project.entity.RepairWork;
import com.infinitivus.project.entity.SpareParts;

import java.util.List;

public interface IPersonService {

    public List<Person> allPerson();

    public void savePerson(Person person, MobileHome mobileHome,List<RepairWork> repairWorkList);

    public Person getPerson(int id);

    public void deletePerson(int id);

    public List<Person> searchPerson(String searchLine);

   public List<Person> sortPerson(String sortLine);

   public boolean verificationSchema();
}
