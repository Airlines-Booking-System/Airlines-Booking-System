package com.app.services;

import com.app.dtos.BookFightDTO;
import com.app.entities.BookingDetails;

public interface BookFlightService {

    BookingDetails bookFlight(BookFightDTO bookFlightDto);
    
}
