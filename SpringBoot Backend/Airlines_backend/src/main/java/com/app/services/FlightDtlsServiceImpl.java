package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.FlightDtlsDao;
import com.app.entities.FlightDtls;


@Service
public class FlightDtlsServiceImpl implements FlightDtlsService {

	@Autowired
	private FlightDtlsDao dao;
	
	@Override
	public List<FlightDtls> getAllFlights() {
		return dao.findAll();
	}



}
