package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.example.entity.User;
import com.example.jwt.AuthenticationRequest;
import com.example.jwt.AuthenticationResponse;
import com.example.jwt.JwtUtil;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    /*
     * REGISTER
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @RequestBody User user) {

        try {

            User savedUser =
                    userService.registerUser(user);

            return ResponseEntity.ok(
                    "User Registered Successfully");

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    /*
     * LOGIN
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody AuthenticationRequest request) {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()));

            String jwt =
                    jwtUtil.generateToken(
                            request.getUsername());

            return ResponseEntity.ok(
                    new AuthenticationResponse(jwt));

        } catch (BadCredentialsException e) {

            return ResponseEntity.badRequest()
                    .body("Invalid Username or Password");

        } catch (Exception e) {

            return ResponseEntity.internalServerError()
                    .body("Login Failed");
        }
    }
}