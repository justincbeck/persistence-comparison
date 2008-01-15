package com.beckproduct.persistence.executable;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.beckproduct.persistence.domain.HibernatePerson;
import com.beckproduct.persistence.exception.ServiceException;
import com.beckproduct.persistence.service.PersonService;

public class HibernateDriver
{

    private PersonService service;

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        HibernateDriver driver = new HibernateDriver();
        try
        {
            driver.setup();
            driver.exercise();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void exercise() throws ServiceException
    {
        HibernatePerson person = new HibernatePerson();
        person.setName("Anna");

        service.createPerson(person);

//        person.setName("Sarah");
//        service.updatePerson(person);
//
//        String id = person.getId();
//        service.getPerson(id);
//
//        service.deletePerson(person);
    }

    private void setup() throws FileNotFoundException, IOException
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("conf/applicationContext.xml");
        service = (PersonService) context.getBean("personService");
    }
}
