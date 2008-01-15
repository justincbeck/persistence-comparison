package com.beckproduct.persistence.exception;

import org.apache.log4j.Logger;

/**
 * repository exception.
 * <p>
 * 
 * @version $Revision$
 * @author $Author$
 */
public class RepositoryException extends Exception
{
    static final long serialVersionUID = 1l;

    /**
     * Logger for this class.
     * <p>
     */
    static Logger logger = Logger.getLogger(RepositoryException.class);

    public RepositoryException(String message)
    {
        super(message);
    }

    public RepositoryException(String message, Exception e)
    {
        super(message, e);
    }
}
