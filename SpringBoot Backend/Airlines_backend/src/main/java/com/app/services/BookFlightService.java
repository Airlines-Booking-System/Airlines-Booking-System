package com.app.services;

import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFlightDTO;
import com.app.dtos.ViewProfileDTO;
import com.app.entities.BookingDetails;

public interface BookFlightService {

    BookingDetails bookFlight(BookFlightDTO bookFlightDto);

    BookFlightDTO viewMyBookedFlights(Integer id);

    String cancelFlight(Integer id);

    ViewProfileDTO viewProfile(Integer id);

    String addPassenger(AddPassengerDTO dto);

    void editProfile(ViewProfileDTO dto);
    
}
