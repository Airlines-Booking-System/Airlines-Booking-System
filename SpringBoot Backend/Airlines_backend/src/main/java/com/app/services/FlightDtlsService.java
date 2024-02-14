package com.app.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.entities.FlightDetails;

public interface FlightDtlsService {
	public List<FlightDetails> getAllFlights();

    public ResponseEntity< List<FlightDetails>> getCustomeFlightDetails(String toCity, String fromCity, LocalDateTime departure);
}
