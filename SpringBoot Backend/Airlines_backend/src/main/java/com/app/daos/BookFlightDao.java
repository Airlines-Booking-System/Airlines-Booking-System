package com.app.daos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.BookingDetails;

public interface BookFlightDao  extends JpaRepository<BookingDetails, Integer>{
   
    // Integer bookFlight(int cid,int bookingID,int flightID,double farePrice,LocalTime duration,int seatNo,int paymentId)
     
}
