package com.infinitivus.project.dao;

import com.infinitivus.project.entity.Person;
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
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
       session.saveOrUpdate(person);
    }

    @Override
    public Person getPerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class,id);
        return person;
    }

    @Override
    public void deletePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person=getPerson(id);
        session.delete(person);
//      способ ниже удаляет только person
//        Query query = session.createQuery("delete from Person where id=:personId");
//        query.setParameter("personId", id);
//        query.executeUpdate();
    }

    @Override
    public List<Person> searchPerson(String searchLine) {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("from Person  where surname=:search or name=:search or phoneNumber=:search or email=:search");
        query.setParameter("search", searchLine);
        List<Person> selectPerson = query.getResultList();
        return selectPerson;
    }

    @Override
    public List<Person> sortPerson(String sortLine) {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("from Person f order by f." + sortLine);
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
