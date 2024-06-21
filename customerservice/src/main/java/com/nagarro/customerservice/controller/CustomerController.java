package com.nagarro.customerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.customerservice.model.Customer;
import com.nagarro.customerservice.services.CustomerService;

// RestController annotation indicates that this class handles RESTful requests
@RestController
@RequestMapping("/customers") // Base URL mapping for all endpoints in this controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService; // Injecting CustomerService dependency

	// Endpoint to retrieve all customers
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// Endpoint to retrieve a customer by ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
		Optional<Customer> customer = customerService.getCustomerById(id);
		
		// Check if the customer is present
		if (customer.isPresent()) {
			return ResponseEntity.ok(customer.get());
		} else {
			String errorMessage = "Customer not found with id: " + id;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
	}

	// Endpoint to add a new customer
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer addedCustomer = customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedCustomer);
	}

	// Endpoint to update customer details by ID
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		try {
			Customer updatedCustomer = customerService.updateCustomer(id, customer);
			return ResponseEntity.ok(updatedCustomer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	// Endpoint to delete customer details by ID and associated account ID
	@DeleteMapping("/{id}/{accountId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id, @PathVariable Long accountId) {
		customerService.deleteCustomer(id, accountId);
		String successMessage = "Customer details with ID " + id + " and Account ID " + accountId + " deleted successfully";
		return ResponseEntity.ok(successMessage);
	}
}
