package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.FlightDTO;
import com.app.dtos.PaymentDTO;
import com.app.entities.UserDetails;
import com.app.services.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/viewallusers")
    public List<UserDetails> viewAllUsers() {
        return service.viewAllUsers();
        
    }
    
    @PostMapping("/createflight")
    public String CreateFlight(@RequestBody FlightDTO flightToAdd){
        System.out.println(flightToAdd);
        return service.addFlight(flightToAdd);
    }
    
    @GetMapping("/deleteflight/{id}")
    public String deleteFlight(@PathVariable Integer id){
        return service.deleteFlight(id);

    }
    @PostMapping("/editFlight/{id}")
    public String editFlight(@RequestBody FlightDTO flight,@PathVariable Integer id){
        return service.editFlight(flight,id);
    }
    @GetMapping("/getflight/{id}")
    public FlightDTO getFlight(@PathVariable Integer id){
        return service.getFlightById(id);
    }

    // public String assignRoles(){

    // }
    @GetMapping("/allpayment")
    public List<PaymentDTO> viewAllPayments(){
        return service.allPayments();
    }
    
    
}
