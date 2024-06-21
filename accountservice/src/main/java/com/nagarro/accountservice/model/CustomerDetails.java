package com.nagarro.accountservice.model;

import jakarta.persistence.Id;

// Plain Java object representing customer details for transactions
public class CustomerDetails {
   
    @Id
    private String customerId; // Unique identifier for the customer
    private String customerName; // Name of the customer

    
    public CustomerDetails() {
        // Default constructor
    }

    // Getter for customerId
    public String getCustomerId() {
        return customerId;
    }

    // Setter for customerId
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    // Getter for customerName
    public String getCustomerName() {
        return customerName;
    }

    // Setter for customerName
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
