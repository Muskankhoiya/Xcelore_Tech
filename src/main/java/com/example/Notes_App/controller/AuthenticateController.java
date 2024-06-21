package com.example.Notes_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes_App.configure.JwtUtils;
import com.example.Notes_App.entity.JwtRequest;
import com.example.Notes_App.entity.JwtResponse;
import com.example.Notes_App.servicesimpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl detailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Generates a JWT token for the given username and password.
     *
     * @param jwtRequest - JWT request object containing username and password
     * @return ResponseEntity containing the generated JWT token
     * @throws Exception if the user is not found
     */
    @PostMapping("/generate-token")
    @CrossOrigin("*")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            // Authenticate the user
            authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found");
        }
        // Load user details
        UserDetails userDetails = this.detailsServiceImpl.loadUserByUsername(jwtRequest.getUserName());
        System.out.println(userDetails);
        // Generate JWT token
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * Authenticates the user using the provided username and password.
     *
     * @param username - User's username
     * @param password - User's password
     * @throws Exception if the user is disabled or the credentials are invalid
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            // Use the authentication manager to authenticate the user
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credentials!!");
        }
    }
}
