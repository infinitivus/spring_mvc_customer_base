package com.infinitivus.project.dao.person_dao;

import com.infinitivus.project.entity.person_entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements IPersonRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Person> getAllPerson() {
        Query query = entityManager.createQuery("from Person", Person.class);
        List<Person> allPerson = query.getResultList();
        return allPerson;
    }

    @Override
    public void savePerson(Person person) {
        System.out.println("dao"+person);
        entityManager.merge(person);
    }

    @Override
    public Person getPerson(int id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    @Override
    public void deletePerson(int id) {
        Person person = getPerson(id);
        entityManager.remove(person);
    }

    @Override
    public List<Person> searchPerson(String searchLine) {
        Query query = entityManager.createQuery("from Person where surname=:search or name=:search or phoneNumber=:search or email=:search");
        query.setParameter("search", searchLine);
       List<Person> selectPerson = query.getResultList();
        return selectPerson;
    }

    @Override
    public List<Person> sortPerson(String sortLine) {
        Query query = entityManager.createQuery("from Person f order by f." + sortLine);
       List<Person> sortPerson = query.getResultList();
        return sortPerson;
    }
}
