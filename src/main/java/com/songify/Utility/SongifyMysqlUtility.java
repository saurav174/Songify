package com.songify.Utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongifyMysqlUtility {

    @Autowired
    SessionFactory sessionFactory;

    public List GetListFromQuery(String query)
    {
        List resultList=null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        resultList = session.createSQLQuery(query).list();
        session.getTransaction().commit();
        session.clear();
        session.close();
        return  resultList;
    }

    public boolean SaveObject (Object object)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    }

    public boolean SaveMultipleObject(List<?> objects)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for(Object object : objects)
        {
            session.save(object);
        }
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    }
    public boolean SaveOrUpdate(Object object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    }

    public boolean DeleteObject(Object object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    }

    public List executeNativeMysqlQuery(String query)
    {
        Session session = sessionFactory.openSession();
        List listSql = session.createSQLQuery(query).list();
        return listSql;
    }

    public void DelOrUpdateQuery(String query)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();
        session.clear();
        session.close();
    }
}
