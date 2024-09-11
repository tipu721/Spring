package com.example.reactivecrud.repository;

import com.example.reactivecrud.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
    Mono<User> findByUsername(String username);
}
