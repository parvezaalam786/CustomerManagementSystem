package com.cms.CustomerManagementSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

}
