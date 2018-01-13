package com.it355.projekat.ServicesImpl;

import com.it355.projekat.DAO.PorudzbineDao;
import com.it355.projekat.Models.Orders;
import com.it355.projekat.Services.PorudzbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PorudzbineServiceImpl implements PorudzbineService{
    @Autowired
    private PorudzbineDao porudzbineDao;

    @Override
    public Orders newOrders(Orders orders) {
        return porudzbineDao.newOrders(orders);
    }
}
