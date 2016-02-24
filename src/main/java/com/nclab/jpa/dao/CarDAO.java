package com.nclab.jpa.dao;

import com.nclab.jpa.configuration.HibernateUtil;
import com.nclab.jpa.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Максим on 23.02.2016.
 */

@Stateless
public class CarDAO {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Car getById(Long id){
        Session session = sessionFactory.openSession();
        Car result = (Car) session.get(Car.class,id);
        session.close();
        return result;
    }

    public void saveOrUpdate(Car car){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(car);
        session.getTransaction().commit();
        session.close();
    }


    public void delete(Car car){
        Session session = sessionFactory.openSession();
        session.delete(car);
        session.flush();
        session.close();
    }

    public List<Car> getAllCars(){
        Session session = sessionFactory.openSession();
        List<Car> result = session.createCriteria(Car.class).list();
        session.close();
        return result;
    }
}
