package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFightDTO;
import com.app.entities.BookingDetails;
import com.app.entities.PassangerDetails;
import com.app.services.BookFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        System.out.println("here  "+bookFlightDto);
        return service.bookFlight(bookFlightDto);
    }


    @GetMapping("/viewBookedFlights/{id}")
    public BookFightDTO viewBookedFlights(@PathVariable Integer id) {
        return service.viewMyBookedFlights(id);
    }
    
    @GetMapping("/cancelFlight/{id}")
    public String cancelFlight(@RequestParam Integer id) {
        return service.cancelFlight(id);
    }
    
    
    @GetMapping("/editProfile")
    public String editProfile(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/viewProfile/{id}")
    public BookingDetails getMethodName(@PathVariable Integer id) {
        return service.viewProfile(id); 
    }
    
    @GetMapping("/addPassenger")
    public String addPassenger(@RequestParam AddPassengerDTO dto) {
        return service.addPassenger(dto);
    }
    

    
    
}
