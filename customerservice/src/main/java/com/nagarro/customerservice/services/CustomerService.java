package com.nagarro.customerservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.customerservice.model.Customer;
import com.nagarro.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo; // Injecting CustomerRepository dependency
    
    @Autowired
    private WebClient webClient; // Injecting WebClient dependency for making HTTP requests to another service

    // Retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    // Retrieve a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }

    // Add a new customer
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    // Update customer details by ID
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepo.findById(id);

        if (existingCustomer.isPresent()) {
            existingCustomer.get().setEmail(customer.getEmail());
            existingCustomer.get().setFirst_name(customer.getFirst_name());
            existingCustomer.get().setLast_name(customer.getLast_name());
            existingCustomer.get().setAddress(customer.getAddress());
            existingCustomer.get().setPhone_number(customer.getPhone_number());

            return customerRepo.save(existingCustomer.get());
        } else {
            // If customer with given ID is not present, throw an exception or return an error message
            throw new RuntimeException("Customer with Id " + id + " not found");
        }
    }

    // Delete customer by ID and associated account ID
    public void deleteCustomer(Long id, Long accountId) {
        // Use WebClient to make a DELETE request to another service (account service) for deleting associated account
        webClient.delete()
                .uri("http://localhost:8082/account/deleteAccount/" + accountId)
                .retrieve()
                .bodyToMono(Void.class) // Adjust this based on your actual response type
                .block(); // Block to get the result

        // After deleting the associated account, delete the customer
        customerRepo.deleteById(id);
    }
}
