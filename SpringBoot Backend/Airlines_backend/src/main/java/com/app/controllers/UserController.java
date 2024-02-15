package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFlightDTO;
import com.app.dtos.ViewProfileDTO;
import com.app.entities.BookingDetails;
import com.app.services.BookFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookFlightService service;

    @PostMapping("/bookFlight")
    public ResponseEntity<BookingDetails> postMethodName(@RequestBody BookFlightDTO bookFlightDto) {
        System.out.println("here  "+bookFlightDto);

        return service.bookFlight(bookFlightDto);
    }


    @GetMapping("/viewBookedFlights/{id}")
    public ResponseEntity<?> viewBookedFlights(@PathVariable Integer id) {
        return service.viewMyBookedFlights(id);
    }
    
    @GetMapping("/cancelFlight/{id}")
    public ResponseEntity<?> cancelFlight(@RequestBody Integer id) {
        return service.cancelFlight(id);
    }
    
    
    @GetMapping("/editProfile")
    public ResponseEntity<?> editProfile(@RequestBody ViewProfileDTO dto) {
        return service.editProfile(dto);
    }

    @GetMapping("/viewProfile/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable Integer id) {
        return service.viewProfile(id); 
    }
    
    @GetMapping("/addPassenger")
    public ResponseEntity<?> addPassenger(@RequestBody AddPassengerDTO dto) {
        return service.addPassenger(dto);
    }
    

    
    
}
