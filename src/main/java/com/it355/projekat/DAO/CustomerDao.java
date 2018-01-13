package com.it355.projekat.DAO;

import com.it355.projekat.Models.Customer;

import java.util.List;

public interface CustomerDao {

    public void addCustomer(Customer customer);

    public Customer getCustomerById(int customerId);

    public List<Customer> getAllCustomers();

    //public Customer find(int id);
}
