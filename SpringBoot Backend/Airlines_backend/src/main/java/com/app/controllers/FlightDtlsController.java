package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.FlightDtls;
import com.app.services.FlightDtlsService;

@RestController
@RequestMapping("/flights")
public class FlightDtlsController{
	
	@Autowired
	private FlightDtlsService service;
	
	@GetMapping("/")
	public List<FlightDtls> getAllFlights() {
		return service.getAllFlights();
	}
}
