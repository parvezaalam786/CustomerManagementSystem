package com.cms.CustomerManagementSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    @NonNull
    private int customerId;

    @Column(name = "FirstName")
    @NonNull
    @NotBlank
    @JsonProperty("firstName")
    private String customerFirstName;

    @Column(name = "LastName")
    @NonNull
    @NotBlank
    @JsonProperty("lastName")
    private String customerLastName;

    @Column(name = "Email")
    @NonNull
    @NotBlank
    @JsonProperty("email")
    private String customerEmail;

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
