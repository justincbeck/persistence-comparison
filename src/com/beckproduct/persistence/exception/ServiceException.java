package com.beckproduct.persistence.exception;

import org.apache.log4j.Logger;

/**
 * service exception.
 * <p>
 * 
 * @version $Revision$
 * @author $Author$
 */
public class ServiceException extends Exception
{
    static final long serialVersionUID = 1l;

    /**
     * Logger for this class.
     * <p>
     */
    static Logger logger = Logger.getLogger(ServiceException.class);

    public ServiceException(String message)
    {
        super(message);
    }

    public ServiceException(String message, Exception e)
    {
        super(message, e);
    }
}
