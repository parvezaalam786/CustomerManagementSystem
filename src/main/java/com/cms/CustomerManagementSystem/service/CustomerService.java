package com.cms.CustomerManagementSystem.service;

import com.cms.CustomerManagementSystem.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomer(int customerId);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(int customerId);

}
