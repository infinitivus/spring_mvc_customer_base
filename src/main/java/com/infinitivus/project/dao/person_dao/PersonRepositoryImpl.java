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
        Query query = entityManager.createQuery("from  Person", Person.class);
        return (List<Person>) query.getResultList();
    }

    @Override
    public void savePerson(Person person) {
        entityManager.merge(person);
    }

    @Override
    public Person getPerson(Integer id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void deletePerson(Integer id) {
        Query query = entityManager.createQuery("delete from Person r where r.id = :id");
        query.setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Person> searchPerson(String searchLine) {
        Query query = entityManager.createQuery("from Person where surname=:search or name=:search or phoneNumber=:search or email=:search");
        query.setParameter("search", searchLine);
        return (List<Person>) query.getResultList();
    }

    @Override
    public List<Person> sortPerson(String sortLine) {
        Query query = entityManager.createQuery("from Person f order by f." + sortLine);
        return (List<Person>) query.getResultList();
    }
}
