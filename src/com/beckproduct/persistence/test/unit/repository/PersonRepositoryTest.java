package com.beckproduct.persistence.test.unit.repository;

import java.util.Collection;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.exception.RepositoryException;
import com.beckproduct.persistence.repository.PersonRepository;


public class PersonRepositoryTest extends TestCase
{
    private ApplicationContext applicationContext;

    private PersonRepository personRepository;

    protected void setUp() throws Exception
    {
        super.setUp();

        applicationContext = new FileSystemXmlApplicationContext("conf/testApplicationContext.xml");
        personRepository = (PersonRepository) applicationContext.getBean("personRepository");
    }

    public void testCreatePerson()
    {
        try
        {
            HibernatePerson newPerson = new HibernatePerson();
            newPerson.setName("personName");

            personRepository.create(newPerson);
        }
        catch (RepositoryException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    public void testGetPerson()
    {
        try
        {
            HibernatePerson newPerson = new HibernatePerson();
            newPerson.setName("personName");

            personRepository.create(newPerson);

            HibernatePerson person = (HibernatePerson) personRepository.get(newPerson.getId());
            assertNotNull(person);
        }
        catch (RepositoryException e)
        {
            fail();
        }
    }

    public void testGetAll()
    {
        try
        {
            HibernatePerson newPerson = new HibernatePerson();
            newPerson.setName("personName");

            personRepository.create(newPerson);

            Collection<HibernatePerson> persons = (Collection<HibernatePerson>) personRepository.getAll();
            assertNotNull(persons);
        }
        catch (RepositoryException e)
        {
            fail();
        }
    }

    public void testGetChildren()
    {
        try
        {
            HibernatePerson newPerson = new HibernatePerson();
            newPerson.setName("personName");

            personRepository.create(newPerson);

            Collection<HibernatePerson> children = (Collection<HibernatePerson>) personRepository.getChildren(newPerson.getId());
            assertNotNull(children);
        }
        catch (RepositoryException e)
        {
            fail();
        }
    }

    public void testUpdatePerson()
    {
        try
        {
            HibernatePerson newPerson = new HibernatePerson();
            newPerson.setName("personName");

            personRepository.create(newPerson);
            newPerson.setName("newName");
            
            personRepository.create(newPerson);

            HibernatePerson person = (HibernatePerson) personRepository.get(newPerson.getId());
            assertTrue(person.getName().equalsIgnoreCase("newName"));
        }
        catch (RepositoryException e)
        {
            fail();
        }
    }

    public void testDeletePerson()
    {
        try
        {
            HibernatePerson newPerson = new HibernatePerson();
            newPerson.setName("personName");

            personRepository.create(newPerson);
            
            String id = newPerson.getId();
            
            personRepository.delete(newPerson.getId());

            HibernatePerson person = (HibernatePerson) personRepository.get(id);
            assertNull(person);
        }
        catch (RepositoryException e)
        {
            fail();
        }
    }
}
