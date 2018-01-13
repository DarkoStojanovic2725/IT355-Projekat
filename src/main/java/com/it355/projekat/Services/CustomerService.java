package com.it355.projekat.Services;

import com.it355.projekat.Models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public void addCustomer(Customer customer);

    public Customer getCustomerById(int customerId);

    public List<Customer> getAllCustomers();
}
