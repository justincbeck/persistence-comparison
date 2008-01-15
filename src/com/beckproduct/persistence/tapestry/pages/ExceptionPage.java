package com.beckproduct.persistence.tapestry.pages;

import org.apache.log4j.Logger;
import org.apache.tapestry.IBinding;
import org.apache.tapestry.event.PageBeginRenderListener;
import org.apache.tapestry.event.PageEvent;
import org.apache.tapestry.html.BasePage;

public abstract class ExceptionPage extends BasePage implements PageBeginRenderListener
{
    private static Logger logger = Logger.getLogger(ExceptionPage.class);

    public abstract Throwable getException();

    public abstract void setException(Throwable exception);

    public abstract IBinding getExceptionBinding();

    public abstract void setExceptionBinding(IBinding exceptionBinding);

    public void pageBeginRender(PageEvent arg0)
    {
        if (null != getException())
            logger.error("Exception during persistence-comparison.", getException());
    }
}
