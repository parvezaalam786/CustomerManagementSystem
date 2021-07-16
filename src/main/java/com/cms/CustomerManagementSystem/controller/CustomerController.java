package com.cms.CustomerManagementSystem.controller;

import com.cms.CustomerManagementSystem.exception.response.CMSResponse;
import com.cms.CustomerManagementSystem.model.entity.Customer;
import com.cms.CustomerManagementSystem.service.CustomerService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Builder
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        CMSResponse response = CMSResponse.builder()
                .message("Successfully added customer")
                .data(customerService.addCustomer(customer))
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCustomer() {
        CMSResponse response = CMSResponse.builder()
                .message("Successfully fetched all customers")
                .data(customerService.getAllCustomers())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomer(@PathVariable("customerId") int customerId) {
        CMSResponse response = CMSResponse.builder()
                .message("Successfully fetched customer")
                .data(customerService.getCustomer(customerId))
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        CMSResponse response = CMSResponse.builder()
                .message("Successfully updated customer details")
                .data(customerService.updateCustomer(customer))
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
        CMSResponse response = CMSResponse.builder()
                .message("Successfully deleted customer")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
