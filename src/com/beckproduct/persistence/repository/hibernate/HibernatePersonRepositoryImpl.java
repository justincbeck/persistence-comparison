package com.beckproduct.persistence.repository.hibernate;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.exception.RepositoryException;
import com.beckproduct.persistence.repository.PersonRepository;

public class HibernatePersonRepositoryImpl extends HibernateDaoSupport implements PersonRepository
{
    private Logger logger = Logger.getLogger(HibernatePersonRepositoryImpl.class);

    private PlatformTransactionManager transactionManager;

    public Object create(Object instance) throws RepositoryException
    {
        HibernatePerson person = (HibernatePerson) instance;
        person.setCreated(new Date());
        try
        {
            getHibernateTemplate().save(person);
            getHibernateTemplate().flush();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw new RepositoryException(e.getMessage(), e);
        }
        return person;
    }

    public Object update(Object instance) throws RepositoryException
    {
        HibernatePerson person = (HibernatePerson) instance;
        try
        {
            getHibernateTemplate().update(person);
            getHibernateTemplate().flush();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw new RepositoryException(e.getMessage(), e);
        }
        return person;
    }

    public void delete(Object instance) throws RepositoryException
    {
        try
        {
            getHibernateTemplate().delete(instance);
            getHibernateTemplate().flush();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public void delete(String id) throws RepositoryException
    {
        try
        {
            HibernatePerson target = (HibernatePerson) this.get(id);
            this.delete(target);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public Object get(String id) throws RepositoryException
    {
        Object o;

        try
        {
            o = getHibernateTemplate().get(HibernatePerson.class, id);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw new RepositoryException(e.getMessage(), e);
        }
        return o;
    }

    public Object getAll() throws RepositoryException
    {
        Object o;

        try
        {
            o = getHibernateTemplate().loadAll(HibernatePerson.class);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw new RepositoryException(e.getMessage(), e);
        }
        return o;
    }

    public Object getChildren(final String id) throws RepositoryException
    {
         Object o;

        try
        {
            o = getHibernateTemplate().get(HibernatePerson.class, id);
            return ((HibernatePerson) o).getChildren();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
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
