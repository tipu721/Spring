package com.tipu.spring_security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @GetMapping("/welcome")
    String wellcome(){
        return "welcome";
    }


    @GetMapping("/login")
    String login(){
        return "login";
    }

}
