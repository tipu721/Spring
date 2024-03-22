package com.tipu.spring_security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User")
public class UserController {

    @RequestMapping("/admin")
    String admin(){
        return "Welcome to admin page";
    }
    @RequestMapping("/user")
    String user(){
        return "Welcome to user page";
    }

}
