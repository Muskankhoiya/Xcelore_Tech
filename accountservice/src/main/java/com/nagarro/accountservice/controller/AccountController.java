package com.nagarro.accountservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nagarro.accountservice.model.AccountDetails;
import com.nagarro.accountservice.model.CustomerDetails;
import com.nagarro.accountservice.model.TransactionRequest;
import com.nagarro.accountservice.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Endpoint to add money to an account
    @PostMapping("/addMoney")
    public ResponseEntity<String> addMoney(@RequestBody TransactionRequest request) {
        try {
            // Validate customer details before processing the transaction
            accountService.validateCustomerDetails(request.getCustomerDetails());
            // Perform the add money operation
            accountService.addMoney(request);
            return ResponseEntity.ok("Money added successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Endpoint to withdraw money from an account
    @PostMapping("/withdrawMoney")
    public ResponseEntity<String> withdrawMoney(@RequestBody TransactionRequest request) {
        try {
            // Validate customer details before processing the transaction
            accountService.validateCustomerDetails(request.getCustomerDetails());
            // Perform the withdraw money operation
            accountService.withdrawMoney(request);
            return ResponseEntity.ok("Money withdrawn successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Endpoint to get account details by account ID
    @GetMapping("/getAccountDetails/{accountId}")
    public ResponseEntity<?> getAccountDetails(@PathVariable Long accountId) {
        try {
            // Retrieve account details based on the account ID
            AccountDetails accountDetails = accountService.getAccountDetails(accountId);

            if (accountDetails != null) {
                // Return successful response with account details
                return ResponseEntity.ok(accountDetails);
            } else {
                // Return 404 Not Found response if account details are not found
                String errorMessage = "Account not found with ID: " + accountId;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            String errorMessage = "Error retrieving account details: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    // Endpoint to delete an account by account ID
    @DeleteMapping("/deleteAccount/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId) {
        try {
            // Delete the account based on the account ID
            accountService.deleteAccount(accountId);
            return ResponseEntity.ok("Account deleted successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Endpoint to create a new account with initial balance
    @PostMapping("/createAccount")
    public ResponseEntity<AccountDetails> createAccount(@RequestBody CustomerDetails customerDetails,
                                                        @RequestParam BigDecimal initialBalance) {
        try {
            // Create a new account with the provided customer details and initial balance
            AccountDetails createdAccount = accountService.createAccount(customerDetails, initialBalance);
            return ResponseEntity.ok(createdAccount);
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
