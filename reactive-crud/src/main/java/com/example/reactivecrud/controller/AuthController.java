package com.example.reactivecrud.controller;

import com.example.reactivecrud.dto.AuthRequest;
import com.example.reactivecrud.dto.AuthResponse;
import com.example.reactivecrud.entity.User;
import com.example.reactivecrud.service.UserService;
import com.example.reactivecrud.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {

    private final JWTUtil jwtUtil;

    private final UserService userService;

    public AuthController(JWTUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public Mono<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return userService.findByUsername(authRequest.getUsername())
                .flatMap(userDetails -> {
                    return Mono.just(new AuthResponse(jwtUtil.generateToken(authRequest.getUsername())));
                });
    }
    @PostMapping("/signup")
    public Mono<User> signup(@RequestBody User user) {
        user.setPassword(user.getPassword());
        return userService.save(user);
    }

    @GetMapping("/protected")
    public Mono<ResponseEntity<String>> protectedEndpoint() {
        return Mono.just(ResponseEntity.ok("You have accessed a protected endpoint!"));
    }
}