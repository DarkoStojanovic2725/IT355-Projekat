package com.it355.projekat.ServicesImpl;

import com.it355.projekat.DAO.PorudzbineDetaljiDao;
import com.it355.projekat.Models.OrderDetails;
import com.it355.projekat.Services.PorudzbineDetaljiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PorudzbineDetaljiServiceImpl implements PorudzbineDetaljiService{

    @Autowired
    private PorudzbineDetaljiDao porudzbineDetaljiDao;

    @Override
    public void newOrderDetails(OrderDetails orderDetails) {
        porudzbineDetaljiDao.newOrderDetails(orderDetails);
    }
}
