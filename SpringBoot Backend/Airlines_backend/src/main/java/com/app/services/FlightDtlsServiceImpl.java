package com.app.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.FlightDtlsDao;
import com.app.entities.FlightDetails;


@Service
public class FlightDtlsServiceImpl implements FlightDtlsService {

	@Autowired
	private FlightDtlsDao dao;
	
	@Override
	public List<FlightDetails> getAllFlights() {
		return dao.findAll();
	}



	@Override
	public List<FlightDetails> getCustomeFlightDetails(String toCity, String fromCity, LocalDateTime departure) {
		List<FlightDetails> list = dao.findByCityAndDate(toCity, fromCity, departure);
		System.out.println(list);
		return list;
	}



}
