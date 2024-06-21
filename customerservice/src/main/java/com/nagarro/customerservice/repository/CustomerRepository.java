package com.nagarro.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.customerservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	boolean existsByEmail(String email);

}
