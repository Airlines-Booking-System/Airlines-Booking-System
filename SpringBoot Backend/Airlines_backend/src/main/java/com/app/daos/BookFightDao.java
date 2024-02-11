package com.app.daos;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.BookingDetails;

public interface BookFightDao  extends JpaRepository<BookingDetails, Integer>{
   
    // Integer bookFlight(int cid,int bookingID,int flightID,double farePrice,LocalTime duration,int seatNo,int paymentId)
     
}
