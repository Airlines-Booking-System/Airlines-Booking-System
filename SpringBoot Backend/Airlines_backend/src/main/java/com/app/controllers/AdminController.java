package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/viewallusers")
    public String viewAllUsers(@RequestParam String param) {
        service.viewAllUsers();
        return new String();
    }

    public String CreateFlight(){

    }
    
    public String deleteFlight(){

    }
    public String editFlight(){

    }

    public String assignRoles(){

    }

    public String viewAllPayments(){}
    
    
}
