package com.app.services;

import java.util.List;

import com.app.dtos.FlightDTO;
import com.app.entities.UserDetails;

public interface AdminService {

    List<UserDetails> viewAllUsers();

    String addFlight(FlightDTO flightToAdd);
    
}
