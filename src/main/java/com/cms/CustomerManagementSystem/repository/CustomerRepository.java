package com.cms.CustomerManagementSystem.repository;

import com.cms.CustomerManagementSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Override
    List<Customer> findAll();
}
