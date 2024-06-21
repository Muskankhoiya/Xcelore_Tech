package com.example.Notes_App.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes_App.entity.User;
import com.example.Notes_App.servicesimpl.UserServiceImpl;
import com.example.Notes_App.servicesimpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserDetailsServiceImpl detailsServiceImpl;

    // Endpoint for user registration
    @PostMapping("/user/register")
    @CrossOrigin("*")
    public User register(@RequestBody User user) throws Exception {
        try {
            // Encode the password before storing it in the database
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            return this.userService.createUser(user);
        } catch (Exception e) {
            // Handle the case where a user with the same email already exists
            throw new Exception("User with email " + user.getEmail() + " already exists!!");
        }
    }

    // Endpoint to get the current user
    @GetMapping("/current-user")
    @CrossOrigin("*")
    public User getCurrentUser(Principal principal) {
        System.out.println(principal.getName());
        // Load and return the current user based on the Principal
        return ((User) this.detailsServiceImpl.loadUserByUsername(principal.getName()));
    }
}
