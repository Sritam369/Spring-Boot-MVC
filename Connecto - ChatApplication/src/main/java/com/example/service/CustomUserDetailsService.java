package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        System.out.println(
                "LOADING USER = "
                        + username);
        
        User user =
                userRepository.findByUsername(
                        username);

        if (user == null) {

            System.out.println(
                    "USER NOT FOUND");

            throw new UsernameNotFoundException(
                    "User not found");
        }
        System.out.println("FOUND USER = " + user.getUsername());
        System.out.println("PASSWORD HASH = " + user.getPassword());
        System.out.println(
                "FOUND USER = "
                        + user.getUsername());

        System.out.println(
                "PASSWORD HASH = "
                        + user.getPassword());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>());
    }
}