package com.example.reactivecrud.controller;

import com.example.reactivecrud.dto.AuthRequest;
import com.example.reactivecrud.dto.AuthResponse;
import com.example.reactivecrud.dto.TaskDto;
import com.example.reactivecrud.entity.User;
import com.example.reactivecrud.service.UserService;
import com.example.reactivecrud.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest authRequest) {
        System.out.println(jwtUtil.generateToken(authRequest.getUsername()));
//        Mono<User> monoUser = userService.findByUsername(authRequest.getUsername());
//        return monoUser.map(userDetails -> {
//            if (userDetails.getPassword().equals(authRequest.getPassword())) {
//                return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(authRequest.getUsername())));
//            } else {
//                throw new BadCredentialsException("Invalid username or password");
//            }
//        }).switchIfEmpty(Mono.error(new BadCredentialsException("Invalid username or password")));

        return null;
    }


    @PostMapping("/signup")
    public Mono<ResponseEntity<String>> signup(@RequestBody User user) {
        // Encrypt password before saving
        user.setPassword(user.getPassword());
        return userService.save(user)
                .map(savedUser -> ResponseEntity.ok("User signed up successfully"));
    }

    @GetMapping("/protected")
    public Mono<ResponseEntity<String>>
    protectedEndPoint() {
        return Mono.just(ResponseEntity.ok(
                "You have accessed a protected endpoint!"
        ));
    }

    @PostMapping("/user")
    public Mono<User> getUser(@RequestBody AuthRequest authRequest) {

        return userService.findByUsername(authRequest.getUsername());
    }


}
