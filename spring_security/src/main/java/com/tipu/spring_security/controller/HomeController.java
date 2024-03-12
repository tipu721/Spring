package com.tipu.spring_security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    String wellcome(){
        return "wellcome";
    }

}
