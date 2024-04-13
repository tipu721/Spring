package com.tipu.spring_security.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    String admin(){
        return "Welcome to admin page";
    }
    @RequestMapping("/user")
    @PreAuthorize("hasRole('USER')")
    String user(){

        return "Welcome to user page";
    }

    @RequestMapping("/public")
    String  publicPage(){
        return "Welcome to public page";
    }

}
