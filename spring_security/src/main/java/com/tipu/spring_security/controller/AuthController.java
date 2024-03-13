package com.tipu.spring_security.controller;


import com.tipu.spring_security.entity.User;
import com.tipu.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AuthController {


    @Autowired
    UserService userService;

    @GetMapping("/welcome")
    String wellcome() {
        return "welcome";
    }


    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/register")
    String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    String register(@RequestParam Map<String, String> reqMap){
        userService.save(reqMap);
        return "login";
    }

}
