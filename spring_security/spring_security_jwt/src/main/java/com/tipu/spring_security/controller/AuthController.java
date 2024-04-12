package com.tipu.spring_security.controller;


import com.tipu.spring_security.model.User;
import com.tipu.spring_security.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {


    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    ResponseEntity<String> signup(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>("User Registration success", HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in scuccessfully", HttpStatus.OK);
    }

    @GetMapping("/logout-success")
    ResponseEntity<String> logout(){
        return new ResponseEntity<>("Successfully logout", HttpStatus.OK);
    }

}
