package com.beckproduct.persistence.domain;

import java.util.Collection;
import java.util.Date;

/**
 * Person object.
 * <p>
 */
public class IBatisPerson
{

    private String id;

    private String name;

    private Date created;

    private Collection<IBatisPerson> children;

    /**
     * @return the children
     */
    public Collection<IBatisPerson> getChildren()
    {
        return children;
    }

    /**
     * @param children
     *            the children to set
     */
    public void setChildren(Collection<IBatisPerson> children)
    {
        this.children = children;
    }

    /**
     * @return the created
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * @param created
     *            the created to set
     */
    public void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
