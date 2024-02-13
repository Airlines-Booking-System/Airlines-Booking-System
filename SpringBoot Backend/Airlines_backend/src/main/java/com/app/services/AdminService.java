package com.app.services;

import java.util.List;

import com.app.dtos.FlightDTO;
import com.app.dtos.PaymentDTO;
import com.app.entities.FlightDetails;
import com.app.entities.PaymentDetails;
import com.app.entities.UserDetails;

public interface AdminService {

    List<UserDetails> viewAllUsers();

    String addFlight(FlightDTO flightToAdd);

    String deleteFlight(Integer id);

    FlightDTO getFlightById(Integer id);

    String editFlight(FlightDTO flight);

     List<PaymentDTO> allPayments();
    
}
