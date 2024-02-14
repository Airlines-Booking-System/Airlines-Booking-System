package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.FlightDTO;
import com.app.dtos.PaymentDTO;
import com.app.dtos.UserDTO;
import com.app.entities.UserDetails;
import com.app.services.AdminService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/viewallusers")//done
    public List<UserDTO> viewAllUsers() {
        System.out.println(service.viewAllUsers());
        return service.viewAllUsers();
        
    }
    
    @PostMapping("/createflight")//done
    public String CreateFlight(@RequestBody FlightDTO flightToAdd){
        System.out.println(flightToAdd);
        return service.addFlight(flightToAdd);
    }
    
    @GetMapping("/deleteflight/{id}")//done
    public String deleteFlight(@PathVariable Integer id){
        System.out.println(id);
        return service.deleteFlight(id);

    }
    @PutMapping("/editFlight/{id}") //DONE
    public String editFlight(@RequestBody FlightDTO flight,@PathVariable Integer id){
        System.out.println(flight);
        System.out.println(id);
        return service.editFlight(flight,id);
    }
    @GetMapping("/getflight/{id}")//done
    public FlightDTO getFlight(@PathVariable Integer id){
        return service.getFlightById(id);
    }

    // public String assignRoles(){

    // }
    @GetMapping("/allpayment") //DONE
    public List<PaymentDTO> viewAllPayments(){
        return service.allPayments();
    }

    @GetMapping("/getPaymentByCid/{cid}") //DONE
    public List<PaymentDTO> getMethodName(@PathVariable Integer cid) {
        return service.getPaymentByCid(cid);
    }
    
    
    
}
