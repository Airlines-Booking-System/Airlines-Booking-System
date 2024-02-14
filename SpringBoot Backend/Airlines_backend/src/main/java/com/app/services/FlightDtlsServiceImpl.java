package com.app.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<FlightDetails>> getCustomeFlightDetails(String toCity, String fromCity, LocalDateTime departure) {
		List<FlightDetails> list = dao.findByCityAndDate(toCity, fromCity, departure);
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		//System.out.println(list);
	}



}
