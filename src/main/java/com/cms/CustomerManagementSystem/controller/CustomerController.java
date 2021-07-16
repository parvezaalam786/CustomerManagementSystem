package com.cms.CustomerManagementSystem.controller;

import com.cms.CustomerManagementSystem.exception.response.CMSResponse;
import com.cms.CustomerManagementSystem.model.entity.Customer;
import com.cms.CustomerManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        CMSResponse response = new CMSResponse(); // we can replace this by builder patterns
        response.setMessage("Successfully added customer");
        response.setData(customerService.addCustomer(customer));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCustomer() {
        CMSResponse response = new CMSResponse();
        response.setMessage("Successfully fetched all customers");
        response.setData(customerService.getAllCustomers());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomer(@PathVariable("customerId") int customerId) {
        CMSResponse response = new CMSResponse();
        response.setMessage("Successfully fetched customer");
        response.setData(customerService.getCustomer(customerId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        CMSResponse response = new CMSResponse();
        response.setMessage("Successfully updated customer details");
        response.setData(customerService.updateCustomer(customer));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
        CMSResponse response = new CMSResponse();
        response.setMessage("Successfully deleted customer");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
