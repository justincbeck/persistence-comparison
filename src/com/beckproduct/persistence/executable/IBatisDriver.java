package com.beckproduct.persistence.executable;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.beckproduct.persistence.domain.IBatisPerson;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IBatisDriver
{

    private static SqlMapClient sqlMap = null;

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        IBatisDriver driver = new IBatisDriver();
        
        driver.setup();
//        if (Boolean.parseBoolean(args[0]))
//            driver.exerciseGenerated();
//        else
            driver.exercise();
    }

    private void setup()
    {
        try
        {
            String resource = "sqlMap-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

//    private void exerciseGenerated()
//    {
//        try
//        {
//            IBatisPersonGenerated person = new IBatisPersonGenerated();
//            person.setId("iBatisID");
//            person.setName("Justin");
//            sqlMap.insert("abatorgenerated_insert", person);
//            
//            IBatisPersonGenerated newPerson = (IBatisPersonGenerated) sqlMap.queryForObject("abatorgenerated_selectByPrimaryKey", person);
//            
//            newPerson.setName("Sarah");
//            sqlMap.update("abatorgenerated_updateByPrimaryKey", newPerson);
//            
//            sqlMap.delete("abatorgenerated_deleteByPrimaryKey", newPerson);
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }

    private void exercise()
    {
        try
        {
            IBatisPerson person = new IBatisPerson();
            person.setId("iBatisID");
            person.setName("Justin");
            sqlMap.insert("createPerson", person);
            
            IBatisPerson newPerson = (IBatisPerson) sqlMap.queryForObject("getPerson", person.getId());
            
            newPerson.setName("Sarah");
            sqlMap.update("updatePerson", newPerson);
            
            sqlMap.delete("deletePerson", newPerson);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
