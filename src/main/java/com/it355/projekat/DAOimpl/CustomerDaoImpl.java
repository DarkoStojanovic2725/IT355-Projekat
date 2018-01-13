package com.it355.projekat.DAOimpl;

import com.it355.projekat.DAO.CustomerDao;
import com.it355.projekat.Models.Customer;
import com.it355.projekat.Models.Permissions;
import com.it355.projekat.Models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addCustomer(Customer customer) {

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);

        Permissions permissions = new Permissions();
        permissions.setUsername(customer.getUsername());
        permissions.setPermissionName("ROLE_USER");

        getSession().saveOrUpdate(newUser);
        getSession().saveOrUpdate(permissions);

        getSession().saveOrUpdate(customer);

        getSession().flush();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = (Customer) getSession().createCriteria(Customer.class).add(Restrictions.eq("id", customerId)).uniqueResult();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> results = (List<Customer>) getSession().createCriteria(Customer.class).list();
        return results;
    }

//    @Override
//    public Customer find(int id) {
//        return (Customer) getSession().get(Customer.class, id);
//    }
}
