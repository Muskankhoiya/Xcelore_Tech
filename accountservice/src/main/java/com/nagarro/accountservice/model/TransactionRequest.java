package com.nagarro.accountservice.model;

import java.math.BigDecimal;

public class TransactionRequest {
    private CustomerDetails customerDetails;
    private BigDecimal amount;
    private Long accountId;

    public TransactionRequest() {
        // Default constructor
    }

    // Getters and setters
    public Long getAccountId() {
        return accountId;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}