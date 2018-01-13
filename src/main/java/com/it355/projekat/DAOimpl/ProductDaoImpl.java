package com.it355.projekat.DAOimpl;

import com.it355.projekat.DAO.ProductDao;
import com.it355.projekat.Models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class ProductDaoImpl implements ProductDao {


    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Product addProduct(Product product) {
        return (Product) getSession().merge(product);
    }

    @Override
    public void editProduct(Product product) {
        getSession().saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(Product product) {
        getSession().delete(getSession().merge(product));
    }

    @Override
    public List<Product> getProducts() {
        List<Product> results = (List<Product>) getSession().createCriteria(Product.class).list();
        return results;
    }

    @Override
    public Product getProductById(int id) {
        Product product = (Product) getSession().createCriteria(Product.class).add(Restrictions.eq("id", id)).uniqueResult();
        return product;
    }

    @Override
    public int countProds() {
        Number result = (Number) getSession().createSQLQuery("select count(*) from product").uniqueResult();
        return Integer.parseInt(result.toString());
    }
}
