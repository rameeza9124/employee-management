package com.example.employee_management.service;

import org.springframework.stereotype.Service;
@Service
public class HomeService {

   public String homeMessage(){
        return """ 
                Welcome to Employ-management System
                This is my SpringBoot Application
                Day 2 """;
    }
}
