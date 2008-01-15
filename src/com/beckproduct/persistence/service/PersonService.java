package com.beckproduct.persistence.service;

import java.util.Collection;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.exception.ServiceException;

public interface PersonService
{
    public HibernatePerson createPerson(HibernatePerson user) throws ServiceException;
    
    public HibernatePerson getPerson(String id) throws ServiceException;
    
    public Collection<HibernatePerson> getPersons() throws ServiceException;
    
    public Collection<HibernatePerson> getChildren(String id) throws ServiceException;
    
    public HibernatePerson updatePerson(HibernatePerson user) throws ServiceException;
    
    public void deletePerson(HibernatePerson user) throws ServiceException;
    
    public void deletePerson(String id) throws ServiceException;
}
