//package com.example.controller;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.stereotype.Controller;
//
//import com.example.entity.ChatMessage;
//
//@Controller
//public class WebSocketChatController {
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(
//            ChatMessage chatMessage) {
//
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(
//            ChatMessage chatMessage,
//            SimpMessageHeaderAccessor headerAccessor) {
//
//        headerAccessor
//                .getSessionAttributes()
//                .put(
//                    "username",
//                    chatMessage.getSender()
//                );
//
//        return chatMessage;
//    }
//}