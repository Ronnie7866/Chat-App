package com.example.chatapp;

import com.example.chatapp.user.Status;
import com.example.chatapp.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
