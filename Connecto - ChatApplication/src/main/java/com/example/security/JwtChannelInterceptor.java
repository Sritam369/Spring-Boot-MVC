package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import com.example.jwt.JwtUtil;

@Component
public class JwtChannelInterceptor implements ChannelInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Message<?> preSend(Message<?> message,
                              MessageChannel channel) {

        StompHeaderAccessor accessor =
                StompHeaderAccessor.wrap(message);

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {

            System.out.println("===== STOMP CONNECT =====");

            String authHeader =
                    accessor.getFirstNativeHeader("Authorization");

            System.out.println(
                    "AUTH HEADER = " + authHeader);

            if (authHeader == null ||
                    !authHeader.startsWith("Bearer ")) {

                System.out.println(
                        "JWT HEADER MISSING");

                throw new RuntimeException(
                        "Missing JWT Token");
            }

            String token =
                    authHeader.substring(7);

            System.out.println(
                    "TOKEN = " + token);

            try {

                String username =
                        jwtUtil.extractUsername(token);

                System.out.println(
                        "USERNAME = " + username);

                accessor.getSessionAttributes()
                        .put("username", username);

                System.out.println(
                        "JWT VALIDATION SUCCESS");

            } catch (Exception e) {

                System.out.println(
                        "JWT VALIDATION FAILED");

                e.printStackTrace();

                throw new RuntimeException(
                        "Invalid JWT Token");
            }
        }

        return message;
    }
}