package com.beckproduct.persistence.test.unit.service;

import junit.framework.TestCase;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.exception.ServiceException;
import com.beckproduct.persistence.repository.mock.PersonRepositoryImpl;
import com.beckproduct.persistence.service.PersonServiceImpl;

public class PersonServiceTest extends TestCase
{
    private PersonServiceImpl personService;

    private PersonRepositoryImpl personRepository;

    protected void setUp() throws Exception
    {
        super.setUp();

        personService = new PersonServiceImpl();
        personRepository = new PersonRepositoryImpl();
        personService.setPersonRepository(personRepository);
    }

    public void testCreatePerson()
    {
        try
        {
            HibernatePerson person = new HibernatePerson();
            person = personService.createPerson(person);

            assertFalse(person.getId().equalsIgnoreCase(""));
        }
        catch (ServiceException e)
        {
            fail();
        }
    }

    public void testGetPerson()
    {
        try
        {
            HibernatePerson person = null;
            person = personService.getPerson("HibernateID");

            assertNotNull(person);
        }
        catch (ServiceException e)
        {
            fail();
        }
    }

    public void testUpdatePerson()
    {
        try
        {
            HibernatePerson person = new HibernatePerson();
            person = personService.updatePerson(person);

            assertNotNull(person);
        }
        catch (ServiceException e)
        {
            fail();
        }
    }

    public void testDeletePerson()
    {
        try
        {
            personService.deletePerson(new HibernatePerson());
            personService.deletePerson("HibernateID");

            assertTrue(true);
        }
        catch (ServiceException e)
        {
            fail();
        }
    }
}
