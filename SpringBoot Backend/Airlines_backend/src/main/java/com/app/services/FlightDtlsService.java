package com.app.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.app.entities.FlightDetails;

public interface FlightDtlsService {
	public List<FlightDetails> getAllFlights();

    public List<FlightDetails> getCustomeFlightDetails(String toCity, String fromCity, LocalDateTime departure);
}
