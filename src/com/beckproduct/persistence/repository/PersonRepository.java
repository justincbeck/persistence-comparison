package com.beckproduct.persistence.repository;

import com.beckproduct.persistence.exception.RepositoryException;

public interface PersonRepository
{
    public Object create(Object instance) throws RepositoryException;
    
    public Object update(Object instance) throws RepositoryException;

    public Object get(String id) throws RepositoryException;
    
    public Object getAll() throws RepositoryException;
    
    public Object getChildren(String id) throws RepositoryException;
    
    public void delete(Object instance) throws RepositoryException;
    
    public void delete(String id) throws RepositoryException;
}
