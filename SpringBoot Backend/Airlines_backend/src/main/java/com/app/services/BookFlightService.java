package com.app.services;

import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFightDTO;
import com.app.dtos.ViewProfileDTO;
import com.app.entities.BookingDetails;
import com.app.entities.GeneralDetails;

public interface BookFlightService {

    BookingDetails bookFlight(BookFightDTO bookFlightDto);

    BookFightDTO viewMyBookedFlights(Integer id);

    String cancelFlight(Integer id);

    ViewProfileDTO viewProfile(Integer id);

    String addPassenger(AddPassengerDTO dto);

    void editProfile(ViewProfileDTO dto);
    
}
