package com.app.services;

import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFightDTO;
import com.app.entities.BookingDetails;

public interface BookFlightService {

    BookingDetails bookFlight(BookFightDTO bookFlightDto);

    BookFightDTO viewMyBookedFlights(Integer id);

    String cancelFlight(Integer id);

    BookingDetails viewProfile(Integer id);

    String addPassenger(AddPassengerDTO dto);
    
}
