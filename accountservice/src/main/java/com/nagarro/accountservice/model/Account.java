package com.nagarro.accountservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts") // Specifies the name of the database table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private BigDecimal balance;
    private String customerId;
    private String customerName;

    public Account() {
        // default constructor
    }

    // Constructor with parameters for creating an account
    public Account(BigDecimal balance, String customerId, String customerName) {
        this.balance = balance;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    // Getters and setters

    // Getter for accountId
    public Long getAccountId() {
        return accountId;
    }

    // Setter for accountId
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    // Getter for balance
    public BigDecimal getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
