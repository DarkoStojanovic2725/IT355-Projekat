package com.it355.projekat.DAOimpl;

import com.it355.projekat.DAO.PorudzbineDetaljiDao;
import com.it355.projekat.Models.OrderDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class PorudzbineDetaljiDaoImpl implements PorudzbineDetaljiDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void newOrderDetails(OrderDetails orderDetails) {
        getSession().saveOrUpdate(orderDetails);
        getSession().flush();
    }
}
