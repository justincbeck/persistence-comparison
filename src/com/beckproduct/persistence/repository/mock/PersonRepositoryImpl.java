package com.beckproduct.persistence.repository.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.repository.PersonRepository;

public class PersonRepositoryImpl extends HibernateDaoSupport implements PersonRepository
{
    public Object create(Object instance)
    {
        HibernatePerson person = (HibernatePerson) instance;
        person.setId("HibernateID");
        person.setName("personname");
        return person;
    }

    public Object update(Object instance)
    {
        return instance;
    }

    public void delete(Object instance)
    {
        return;
    }

    public void delete(String id)
    {
        return;
    }

    public Object get(String personName)
    {
        HibernatePerson person = new HibernatePerson();
        person.setId("HibernateID");
        person.setName("personname");
        return person;
    }

    public Object getAll()
    {
        Collection<HibernatePerson> c = new ArrayList<HibernatePerson>();
        
        HibernatePerson person = new HibernatePerson();
        person.setId("HibernateID");
        person.setName("personname");
        
        c.add(person);
        return c;
    }

    public Object getChildren(String id)
    {
        Collection<HibernatePerson> c = new ArrayList<HibernatePerson>();
        
        HibernatePerson person = new HibernatePerson();
        person.setId("HibernateID");
        person.setName("personname");
        
        c.add(person);
        return c;
    }
}
