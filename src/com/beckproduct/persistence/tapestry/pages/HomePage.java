package com.beckproduct.persistence.tapestry.pages;

import org.apache.log4j.Logger;
import org.apache.tapestry.event.PageBeginRenderListener;
import org.apache.tapestry.event.PageEvent;
import org.apache.tapestry.html.BasePage;

public abstract class HomePage extends BasePage implements PageBeginRenderListener
{
    private Logger logger = Logger.getLogger(HomePage.class);
    
    public void pageBeginRender(PageEvent event)
    {
        logger.info("Rendering page..");
    }
}
