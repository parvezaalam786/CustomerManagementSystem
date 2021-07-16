package com.cms.CustomerManagementSystem.service.Impl;

import com.cms.CustomerManagementSystem.exception.CMSException;
import com.cms.CustomerManagementSystem.model.entity.Customer;
import com.cms.CustomerManagementSystem.repository.CustomerRepository;
import com.cms.CustomerManagementSystem.service.CustomerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @SneakyThrows
    @Override
    public Customer addCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new CMSException("Failed to add customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SneakyThrows
    @Override
    public List<Customer> getAllCustomers() {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new CMSException("Failed to fetch customers data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SneakyThrows
    @Override
    public Customer getCustomer(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new CMSException("Customer with id: " + customerId + " does not exist in DB.", HttpStatus.BAD_REQUEST);
        }
        return customer.get();
    }

    @SneakyThrows
    @Override
    public Customer updateCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new CMSException("Failed to update customer data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SneakyThrows
    @Override
    public void deleteCustomer(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new CMSException("Customer with id: " + customerId + " does not exist in DB.", HttpStatus.BAD_REQUEST);
        }
        customerRepository.deleteById(customerId);
    }
}
