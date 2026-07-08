package com.example.employee_management.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
@Service
public class HomeService {

    @PostConstruct
    public void init(){
        System.out.println("HomeService Bean Initialized");
    }

   public String homeMessage(){
        return """ 
                Welcome to Employ-management System
                This is my SpringBoot Application
                Day 2 """;
    }


    @PreDestroy
    public void destroy(){
        System.out.println("HomeService Bean Destroyed");
    }

}
