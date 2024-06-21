package com.nagarro.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    private String first_name;
	    private String last_name;
	    private String gender;
	    private String email;
	    private Long phone_number;
	    private String address;
	    private Long accountId;
	 
	        
		//Default Constructor
	    public Customer() {
		
		}
		
		public Customer(Long id, String first_name, String last_name, String gender, String email, Long phone_number,
				String address, Long accountId) {
			super();
			this.id = id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.gender = gender;
			this.email = email;
			this.phone_number = phone_number;
			this.address = address;
			this.accountId = accountId;
		}


	
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(Long phone_number) {
			this.phone_number = phone_number;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		

		public Long getAccountId() {
			return accountId;
		}

		public void setAccountId(Long accountId) {
			this.accountId = accountId;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender="
					+ gender + ", email=" + email + ", phone_number=" + phone_number + ", address=" + address
					+ ", accountId=" + accountId + "]";
		}

		

		

}