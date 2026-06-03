package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.example.entity.User;
import com.example.jwt.AuthenticationRequest;
import com.example.jwt.AuthenticationResponse;
import com.example.jwt.JwtUtil;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(
            @RequestBody AuthenticationRequest request)
            throws Exception {

        System.out.println(
                "LOGIN ATTEMPT = "
                        + request.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        System.out.println(
                "AUTH SUCCESS");

        String jwt =
                jwtUtil.generateToken(
                        request.getUsername());

        System.out.println(
                "JWT GENERATED = "
                        + jwt);

        return new AuthenticationResponse(jwt);
    }
}