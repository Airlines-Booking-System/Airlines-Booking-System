package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.BookingDetails;

public interface BookingDtlsDao extends JpaRepository<BookingDetails,Integer>{

}
