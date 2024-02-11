package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.BookFightDTO;
import com.app.entities.BookingDetails;
import com.app.services.BookFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookFlightService service;

    @PostMapping("/bookFlight")
    public BookingDetails postMethodName(@RequestBody BookFightDTO bookFlightDto) {
        System.out.println(bookFlightDto);
        return service.bookFlight(bookFlightDto);
    }


    @GetMapping("/viewBookedFlights")
    public String viewBookedFlights(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/cancelFlight")
    public String cancelFlight(@RequestParam String param) {
        return new String();
    }
    
    
    @GetMapping("/editProfile")
    public String editProfile(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/viewProfile")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/addPassenger")
    public String addPassenger(@RequestParam String param) {
        return new String();
    }
    

    
    
}
