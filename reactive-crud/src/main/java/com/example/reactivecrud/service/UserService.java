package com.example.reactivecrud.service;

import com.example.reactivecrud.entity.User;
import com.example.reactivecrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<User> save(User user) {
        user.setPassword(user.getPassword()); // Encrypt password before saving
        return userRepository.save(user);

    }
}