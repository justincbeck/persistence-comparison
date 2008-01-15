package com.beckproduct.persistence.domain;

import java.util.Collection;
import java.util.Date;

/**
 * Person object.
 * <p>
 * 
 * @hibernate.class table="person" lazy="false"
 */
public class HibernatePerson
{
    private String id;

    private String name;

    private Date created;
    
    private HibernatePerson parent;
    
    private Collection<HibernatePerson> children;

    /**
     * @hibernate.set name="children" lazy="false" cascade="all" table="person" inverse="true"
     * @hibernate.collection-key column="parent_id"
     * @hibernate.collection-one-to-many class="com.beckproduct.persistence.domain.HibernatePerson"
     * 
     * @return the children
     */
    public Collection<HibernatePerson> getChildren()
    {
        return children;
    }

    /**
     * @param children
     *            the children to set
     */
    public void setChildren(Collection<HibernatePerson> children)
    {
        this.children = children;
    }

    /**
     * @hibernate.many-to-one name="parent" column="parent_id" cascade="save-update"
     *                        class="com.beckproduct.persistence.domain.HibernatePerson"
     */
    public HibernatePerson getParent()
    {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(HibernatePerson parent)
    {
        this.parent = parent;
    }

    /**
     * @hibernate.property column="created" type="timestamp" update="false"
     *                     insert="true"
     * 
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
     * @hibernate.id column="id" generator-class="uuid.hex"
     * 
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
     * @hibernate.property column="name" type="string" length="75" update="true"
     *                     insert="true"
     * 
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
