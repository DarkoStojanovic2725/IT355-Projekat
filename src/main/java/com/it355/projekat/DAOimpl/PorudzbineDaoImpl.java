package com.it355.projekat.DAOimpl;

import com.it355.projekat.DAO.PorudzbineDao;
import com.it355.projekat.Models.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class PorudzbineDaoImpl implements PorudzbineDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Orders newOrders(Orders orders) {
        getSession().saveOrUpdate(orders);
        getSession().flush();
        return orders;
    }
}
