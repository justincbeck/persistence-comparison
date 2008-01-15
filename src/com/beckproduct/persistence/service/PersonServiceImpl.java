package com.beckproduct.persistence.service;

import java.util.Collection;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.exception.RepositoryException;
import com.beckproduct.persistence.exception.ServiceException;
import com.beckproduct.persistence.repository.PersonRepository;

public class PersonServiceImpl implements PersonService
{
    private PersonRepository personRepository;

    public HibernatePerson createPerson(HibernatePerson person) throws ServiceException
    {
        try
        {
            return (HibernatePerson) personRepository.create(person);
        }
        catch (RepositoryException re)
        {
            throw new ServiceException(re.getMessage(), re);
        }
    }

    public HibernatePerson getPerson(String id) throws ServiceException
    {
        try
        {
            return (HibernatePerson) personRepository.get(id);
        }
        catch (RepositoryException re)
        {
            throw new ServiceException(re.getMessage(), re);
        }
    }
    
    public Collection<HibernatePerson> getPersons() throws ServiceException
    {
        try
        {
            return (Collection<HibernatePerson>) personRepository.getAll();
        }
        catch (RepositoryException re)
        {
            throw new ServiceException (re.getMessage(), re);
        }
    }

    public Collection<HibernatePerson> getChildren(String id) throws ServiceException
    {
        try
        {
            return (Collection<HibernatePerson>) personRepository.getChildren(id);
        }
        catch (RepositoryException re)
        {
            throw new ServiceException (re.getMessage(), re);
        }
    }

    public HibernatePerson updatePerson(HibernatePerson person) throws ServiceException
    {
        try
        {
            return (HibernatePerson) personRepository.update(person);
        }
        catch (RepositoryException re)
        {
            throw new ServiceException(re.getMessage(), re);
        }
    }

    public void deletePerson(HibernatePerson person) throws ServiceException
    {
        try
        {
            personRepository.delete(person);
        }
        catch (RepositoryException re)
        {
            throw new ServiceException(re.getMessage(), re);
        }
    }

    public void deletePerson(String id) throws ServiceException
    {
        try
        {
            personRepository.delete(id);
        }
        catch (RepositoryException re)
        {
            throw new ServiceException(re.getMessage(), re);
        }
    }

    /**
     * @return the personRepository
     */
    public PersonRepository getPersonRepository()
    {
        return personRepository;
    }

    /**
     * @param personRepository
     *            the personRepository to set
     */
    public void setPersonRepository(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }
}
