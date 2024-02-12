package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.FlightDTO;
import com.app.entities.UserDetails;
import com.app.services.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/viewallusers")
    public List<UserDetails> viewAllUsers() {
        return service.viewAllUsers();
        
    }

    public String CreateFlight(@RequestParam FlightDTO flightToAdd){
        return service.addFlight(flightToAdd);
    }
    
    // public String deleteFlight(){

    // }
    // public String editFlight(){

    // }

    // public String assignRoles(){

    // }

    // public String viewAllPayments(){}
    
    
}
