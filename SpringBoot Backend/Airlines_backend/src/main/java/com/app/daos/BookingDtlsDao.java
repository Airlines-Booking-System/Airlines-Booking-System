package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.BookingDetails;
import com.app.entities.UserDetails;

public interface BookingDtlsDao extends JpaRepository<BookingDetails,Integer>{
    List<BookingDetails> findByCustomerId(UserDetails customerId);
}
