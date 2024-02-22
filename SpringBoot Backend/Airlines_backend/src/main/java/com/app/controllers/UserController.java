package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFlightDTO;
import com.app.dtos.PaymentDTO;
import com.app.dtos.ViewProfileDTO;
import com.app.services.BookFlightService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class UserController {
    @Autowired
    private BookFlightService service;
    
    @Autowired
    private HttpSession session;

    @GetMapping("/see")
    public void testing() {
		System.out.println("email mila  "+ (Integer)session.getAttribute("userid"));

    }
    @GetMapping("/getAvailabeSeats/{flightId}")
    public ResponseEntity<?> getAvailableSeats(@PathVariable  Integer flightId) {
    	System.out.println("hieee im hereeee in getavailable seats wale api mai "+flightId);

        return service.getAvailableSeats(flightId);
    }
    

    @PostMapping("/bookFlight") // TESTED!!!!!!
    public ResponseEntity<?> postMethodName(@RequestBody BookFlightDTO bookFlightDto) {
        System.out.println("here  "+bookFlightDto);

        return service.bookFlight(bookFlightDto);
    }


    @GetMapping("/viewBookedFlights/{id}") // DONE ++
    public ResponseEntity<?> viewBookedFlights(@PathVariable Integer id) {
        return service.viewMyBookedFlights(id);
    }
    
    @DeleteMapping("/cancelFlight/{id}") // DONE ++
    public ResponseEntity<?> cancelFlight(@PathVariable Integer id) {
        return service.cancelFlight(id);
    }
    
    
    @PutMapping("/editProfile/{id}") // DONE 
    public ResponseEntity<?> editProfile(@RequestBody ViewProfileDTO dto, @PathVariable Integer id) {
        return service.editProfile(dto, id);
    }

    @GetMapping("/viewProfile/{id}") // DONE
    public ResponseEntity<?> viewProfileById(@PathVariable Integer id) {
        return service.viewProfile(id); 
    }
    
    @PostMapping("/addPassenger/{cid}") // DONE!
    public ResponseEntity<?> addPassenger(@RequestBody AddPassengerDTO dto, @PathVariable Integer cid) {
        return service.addPassenger(dto, cid);
    }

    @GetMapping("/viewPassengers/{cid}") // DONE!
    public ResponseEntity<?> viewPassengers(@PathVariable Integer cid) {
        return service.viewPassengers(cid);
    }

    @PostMapping("/makePayment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDTO paymentDTO) {
        System.out.println("\n\n" + "inside user Controller!" + "\n\n");
        return service.makePayment(paymentDTO);
    }
    
    
    
}
