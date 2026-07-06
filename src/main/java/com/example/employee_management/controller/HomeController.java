package com.example.employee_management.controller;

import com.example.employee_management.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public String home(){
//        return """
//                Welcome to Employ-management System
//                I am Learning Spring Boot
//                Its my Day 1
//                """;
        return homeService.homeMessage();

    }

    @GetMapping("/about")
    public String about(){
        return "I am Learning SpringBoot";
    }

    @GetMapping("/contact")
    public String contact(){
//       String email = "simi@gmail.com";
//       return email;

        return """
                Name: Simi
                Email: simi@gmail.com
                Learning: SpringBoot""";
    }

}
