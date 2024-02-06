package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.daos.FlightDtlsDao;
import com.app.entities.FlightDtls;

public class FlightDtlsServiceImpl implements FlightDtlsService {

	@Autowired
	private FlightDtlsDao dao;
	
	@Override
	public String getAllFlights() {
		List<FlightDtls> all = dao.findAll();
		return all.toString();
	}



}
