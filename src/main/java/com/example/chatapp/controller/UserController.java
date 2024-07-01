package com.example.chatapp.controller;

import com.example.chatapp.UserService;
import com.example.chatapp.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public User addUser(@Payload User user) {
        service.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public User disconnect(@Payload User user) {
        service.disconnect(user);
        return user;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> findConnectedUser() {
        List<User> connectedUser = service.findConnectedUser();
        return ResponseEntity.ok(connectedUser);
    }

}
