package com.example.Notes_App.services;



import java.util.List;
import java.util.Set;

import com.example.Notes_App.entity.User;


public interface UserService {

	// Creates a new user with the given details and associated roles.
	public User createUser(User user) throws Exception;

	// Saves a user in the database.
	public User save(User user);

	// Retrieves a user by their email.
	public User showUser(String email);

	// Retrieves all users.
	public List<User> findAll();

}
