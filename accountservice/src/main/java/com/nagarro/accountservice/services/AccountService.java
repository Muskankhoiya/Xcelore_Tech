package com.nagarro.accountservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.accountservice.model.Account;
import com.nagarro.accountservice.model.AccountDetails;
import com.nagarro.accountservice.model.Customer;
import com.nagarro.accountservice.model.CustomerDetails;
import com.nagarro.accountservice.model.TransactionRequest;
import com.nagarro.accountservice.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService {
	
	@Autowired
	private WebClient webClient;

    @Autowired
    private AccountRepository accountRepository;

    // Method to validate customer details
    public void validateCustomerDetails(CustomerDetails customerDetails) {
        if (customerDetails == null || customerDetails.getCustomerId() == null || customerDetails.getCustomerId().isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Details!!");
        }
    }
    
    // Method to add money to an account
    public void addMoney(TransactionRequest request) {
        validateCustomerDetails(request.getCustomerDetails());

        Optional<Account> optionalAccount = accountRepository.findById(request.getAccountId());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            // Check if account details match with the transaction request
            if (account.getCustomerId().equals(request.getCustomerDetails().getCustomerId()) &&
                    account.getCustomerName().equals(request.getCustomerDetails().getCustomerName())) {
                
                account.setBalance(account.getBalance().add(request.getAmount()));
                accountRepository.save(account);
            } else {
                throw new IllegalArgumentException("Transaction failed. Account details do not match with the provided customer details!!.");
            }
        } else {
            throw new IllegalArgumentException("Account not found!!");
        }
    }

    // Method to withdraw money from an account
    public void withdrawMoney(TransactionRequest request) {
        validateCustomerDetails(request.getCustomerDetails());

        Optional<Account> optionalAccount = accountRepository.findById(request.getAccountId());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            // Check if account details match with the transaction request
            if (account.getCustomerId().equals(request.getCustomerDetails().getCustomerId()) &&
                    account.getCustomerName().equals(request.getCustomerDetails().getCustomerName())) {

                if (account.getBalance().compareTo(request.getAmount()) >= 0) {
                    account.setBalance(account.getBalance().subtract(request.getAmount()));
                    accountRepository.save(account);
                } else {
                    throw new IllegalArgumentException("Insufficient Balance!!");
                }
            } else {
                throw new IllegalArgumentException("Transaction failed. Account details do not match with the provided customer details.");
            }
        } else {
            throw new IllegalArgumentException("Account not found!!");
        }
    }

    // Method to get account details by account ID
    public AccountDetails getAccountDetails(Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            // Assuming you have a Customer class and WebClient is used to fetch customer details
            Customer customer = webClient.get()
                    .uri("http://localhost:8081/customers/" + account.getCustomerId())
                    .retrieve()
                    .bodyToMono(Customer.class) // Adjust this based on your actual response type
                    .block(); // Block to get the result
            System.out.println(customer.getAddress());
            if (customer != null) {
                AccountDetails accountDetails = new AccountDetails();
                accountDetails.setAccountId(account.getAccountId());
                accountDetails.setBalance(account.getBalance());
                accountDetails.setCustomerId(customer.getId().toString());
                accountDetails.setCustomerName(customer.getFirst_name()+ " " + customer.getLast_name());
          //      accountDetails.setCustomerDetails(customer); // Assuming you have setCustomerDetails in AccountDetails
                return accountDetails;
            } else {
                throw new IllegalArgumentException("Customer not found!!");
            }
        } else {
            throw new IllegalArgumentException("Account not found!!");
        }
    }

    // Method to delete an account by account ID
    public void deleteAccount(Long accountId) {
        if (accountRepository.existsById(accountId)) {
            accountRepository.deleteById(accountId);
        } else {
            throw new IllegalArgumentException("Account not found!!");
        }
    }

    // Method to create a new account
    public AccountDetails createAccount(CustomerDetails customerDetails, BigDecimal initialBalance) {
        validateCustomerDetails(customerDetails);

        Account newAccount = new Account();
        newAccount.setCustomerId(customerDetails.getCustomerId());
        newAccount.setCustomerName(customerDetails.getCustomerName());
        newAccount.setBalance(initialBalance);

        Account savedAccount = accountRepository.save(newAccount);

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountId(savedAccount.getAccountId());
        accountDetails.setBalance(savedAccount.getBalance());
        accountDetails.setCustomerId(savedAccount.getCustomerId());
        accountDetails.setCustomerName(savedAccount.getCustomerName());

        return accountDetails;
    }
}
