package com.app.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.FlightDetailsDTO;
import com.app.entities.FlightDetails;
import com.app.services.FlightDtlsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class FlightDetailsController{
	
	@Autowired
	private FlightDtlsService service;
	
	// @GetMapping("/all")
	// public List<FlightDetails> getAllFlights() {
	// 	return service.getAllFlights();
	// }

	@PostMapping("/all")
	public List<FlightDetails> postMethodName(@RequestBody FlightDetailsDTO details) {
		System.out.println(details);
		return service.getCustomeFlightDetails(details.getToCity(), details.getFromCity(), details.getDeparture());
	}
	
}
