package com.beckproduct.persistence.tapestry.pages;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.tapestry.event.PageBeginRenderListener;
import org.apache.tapestry.event.PageEvent;
import org.apache.tapestry.html.BasePage;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.exception.ServiceException;
import com.beckproduct.persistence.service.PersonService;

public abstract class HibernatePage extends BasePage implements PageBeginRenderListener
{
    private Logger logger = Logger.getLogger(HibernatePage.class);

    public abstract PersonService getPersonService();

    public abstract Collection<HibernatePerson> getPersons();

    public abstract void setPersons(Collection<HibernatePerson> persons);
    
    public abstract HibernatePerson getPerson();

    public abstract void setPerson(HibernatePerson person);

    public abstract Collection<HibernatePerson> getChildren();
    
    public abstract void setChildren(Collection<HibernatePerson> children);
    
    public abstract HibernatePerson getChild();
    
    public abstract void setChild(HibernatePerson child);
    
    public void pageBeginRender(PageEvent event)
    {
        logger.info("Getting persons...");

        try
        {
            Collection<HibernatePerson> persons = (Collection<HibernatePerson>) getPersonService().getPersons();
            setPersons(persons);
        }
        catch (ServiceException e)
        {
            setPersons(null);
        }
    }
    
    public void selectParent(String id)
    {
        logger.info("Getting children...");

        try
        {
            Collection<HibernatePerson> children = (Collection<HibernatePerson>) getPersonService().getChildren(id);
            setChildren(children);
        }
        catch (ServiceException e)
        {
            setChildren(null);
        }
    }
}
