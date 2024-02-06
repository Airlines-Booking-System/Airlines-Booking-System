package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.FlightDtls;

public interface FlightDtlsDao extends JpaRepository<FlightDtls, Integer> {

}
