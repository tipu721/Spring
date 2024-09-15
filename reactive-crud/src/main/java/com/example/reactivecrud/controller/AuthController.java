package com.example.reactivecrud.controller;

import com.example.reactivecrud.dto.AuthRequest;
import com.example.reactivecrud.dto.AuthResponse;
import com.example.reactivecrud.entity.User;
import com.example.reactivecrud.service.UserService;
import com.example.reactivecrud.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private JWTUtil jwtUtil;

    private UserService userService;

    public AuthController(JWTUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> authenticate(@RequestBody AuthRequest authRequest) {
        return userService.findByUsername(authRequest.getUsername())
                .flatMap(userDetails -> {
                    if (userDetails.getPassword().equals(authRequest.getPassword())) {
                        return Mono.just(ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(authRequest.getUsername()))));
                    } else {
                        return Mono.error(new BadCredentialsException("Invalid username or password"));
                    }
                })
                .switchIfEmpty(Mono.error(new BadCredentialsException("Invalid username or password")));
    }
    @PostMapping("/signup")
    public Mono<ResponseEntity<String>> signup(@RequestBody User user) {
        // Encrypt password before saving
        user.setPassword(user.getPassword());
        return userService.save(user)
                .map(savedUser -> ResponseEntity.ok("User signed up successfully"));
    }

    @GetMapping("/protected")
    public Mono<ResponseEntity<String>> protectedEndpoint() {
        return Mono.just(ResponseEntity.ok("You have accessed a protected endpoint!"));
    }
}