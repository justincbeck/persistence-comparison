package com.beckproduct.persistence.repository.iBatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;

import com.beckproduct.persistence.domain.IBatisPerson;
import com.beckproduct.persistence.exception.RepositoryException;
import com.beckproduct.persistence.repository.PersonRepository;

public class IBatisPersonRepositoryImpl extends SqlMapClientDaoSupport implements PersonRepository
{
    private PlatformTransactionManager transactionManager;
    
    public Object create(Object instance) throws RepositoryException
    {
        IBatisPerson person = (IBatisPerson) instance;
        try
        {
            getSqlMapClient().insert("createPerson", person);
        }
        catch (Exception e)
        {
            throw new RepositoryException(e.getMessage(), e);
        }
        return person;
    }
    
    public Object update(Object instance) throws RepositoryException
    {
        IBatisPerson person = (IBatisPerson) instance;
        try
        {
            getSqlMapClient().update("updatePerson", person);
        }
        catch (Exception e)
        {
            throw new RepositoryException(e.getMessage(), e);
        }
        return person;
    }

    public void delete(Object instance) throws RepositoryException
    {
        try
        {
            getSqlMapClient().delete("deletePerson", instance);
        }
        catch (Exception e)
        {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public void delete(String id) throws RepositoryException
    {
        try
        {
            IBatisPerson target = (IBatisPerson) this.get(id);
            this.delete(target);
        }
        catch (Exception e)
        {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public Object get(String id) throws RepositoryException
    {
        try
        {
            return getSqlMapClient().queryForObject("getPerson", id);
        }
        catch (Exception e)
        {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public Object getAll() throws RepositoryException
    {
        try
        {
            return getSqlMapClient().queryForObject("getPerson");
        }
        catch (Exception e)
        {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public Object getChildren(String id) throws RepositoryException
    {
        try
        {
            return null;
        }
        catch (Exception e)
        {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    /**
     * @return the transactionManager
     */
    public PlatformTransactionManager getTransactionManager()
    {
        return transactionManager;
    }

    /**
     * @param transactionManager
     *            the transactionManager to set
     */
    public void setTransactionManager(PlatformTransactionManager transactionManager)
    {
        this.transactionManager = transactionManager;
    }
}
