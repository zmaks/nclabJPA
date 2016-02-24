package com.nclab.jpa.dao;

import com.nclab.jpa.configuration.HibernateUtil;
import com.nclab.jpa.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class OwnerDAO {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Owner getById(Long id){
        Session session = sessionFactory.openSession();
        Owner result = (Owner) session.get(Owner.class,id);
        session.close();
        return result;
    }

    public void saveOrUpdate(Owner owner){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(owner);
        session.getTransaction().commit();
        session.close();
    }


    public void delete(Owner owner){
        Session session = sessionFactory.openSession();
        session.delete(owner);
        session.flush();
        session.close();
    }
}
