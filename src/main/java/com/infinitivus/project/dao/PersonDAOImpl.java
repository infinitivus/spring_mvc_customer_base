package com.infinitivus.project.dao;

import com.infinitivus.project.entity.MobileHome;
import com.infinitivus.project.entity.Person;
import com.infinitivus.project.entity.RepairWork;
import com.infinitivus.project.entity.SpareParts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> getAllPerson() {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("from Person", Person.class);
        List<Person> allPerson = query.getResultList();
        return allPerson;
    }

    @Override
    public void savePerson(Person person, MobileHome mobileHome,List<RepairWork> repairWorkList) {
        Session session = sessionFactory.getCurrentSession();
        person.setMobileHome(mobileHome);
        mobileHome.setRepairWorkList(repairWorkList);
        session.saveOrUpdate(person);
    }

    @Override
    public Person getPerson(int id) {
        System.out.println("get " + id);///////////////////////////////////////
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        MobileHome mobileHome = person.getMobileHome();
        RepairWork repairWorks=new RepairWork();
        List<RepairWork> repairWorksList = mobileHome.getRepairWorkList();
    //    List<SpareParts> sparePartsList=repairWorks.getSparePartsList();
        System.out.println("DAO "+repairWorksList);
     //   System.out.println("DAO "+sparePartsList);
        return person;
    }

    @Override
    public void deletePerson(int id) {
        System.out.println("delete " + id);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Person where id=:personId");
        query.setParameter("personId", id);
        query.executeUpdate();
    }

    @Override
    public List<Person> searchPerson(String searchLine) {
        System.out.println(searchLine);////////////////////////////////////////////////////
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person  where surname=:search or name=:search or phoneNumber=:search or email=:search");
        query.setParameter("search", searchLine);
        List<Person> selectPerson = query.getResultList();
        return selectPerson;
    }

    @Override
    public List<Person> sortPerson(String sortLine) {
        System.out.println(sortLine);////////////////////////////////////////////
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person f order by f." + sortLine);
        List<Person> sortPerson = query.getResultList();
        return sortPerson;
    }

    @Override
    public boolean verificationSchema() {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("from Person", Person.class);
        List<Person> allPerson = query.getResultList();
        if (allPerson != null) {
            return true;
        } else {
            return false;
        }
    }
}
