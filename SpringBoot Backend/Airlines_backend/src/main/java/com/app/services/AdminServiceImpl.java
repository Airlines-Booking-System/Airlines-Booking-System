package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.UserDao;
import com.app.dtos.FlightDTO;
import com.app.dtos.PaymentDTO;
import com.app.entities.FlightDetails;
import com.app.entities.PaymentDetails;
import com.app.entities.UserDetails;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserDao uDao;

    @Override
    public List<UserDetails> viewAllUsers() {
        return uDao.findAllUsers();
    }
    @Override
    public String addFlight(FlightDTO flightToAdd) {
        uDao.addFlight(flightToAdd.getArrival(),flightToAdd.getDeparture(),flightToAdd.getDestination(),flightToAdd.getFlightClass(),flightToAdd.getName(),flightToAdd.getSource());
        return "added successfully";
    }
    @Override
    public String deleteFlight(Integer id) {
        uDao.deleteById(id);
        return "deleted succesfully";

    }
    @Override
    public FlightDTO getFlightById(Integer id) {
        FlightDetails flight= uDao.findFlightById(id);
        FlightDTO dto=new FlightDTO();
        dto.setArrival(flight.getArrival());
        dto.setDeparture(flight.getDeparture());
        dto.setDestination(flight.getDestination());
        dto.setFlightClass(flight.getFlightClass());
        dto.setName(flight.getName());
        dto.setSource(flight.getSource());
        return dto;
    }
    @Override
    public String editFlight(FlightDTO flight) {
        FlightDetails details=new FlightDetails();
        details.setArrival(flight.getArrival());
        details.setDeparture(flight.getDeparture());
        details.setDestination(flight.getDestination());
        details.setFlightClass(flight.getFlightClass());
        details.setName(flight.getName());
        details.setSource(flight.getSource());
        // uDao.editFlight();
        return null;
    }
    @Override
    public List<PaymentDTO> allPayments() {
        List<PaymentDetails> list=uDao.getAllPayments();
        List<PaymentDTO> dto=new ArrayList<>();
        for (PaymentDetails p : list) {
            PaymentDTO d=new PaymentDTO();
            d.setFlightName(p.getBookingId().getFlightId().getName());
            d.setStatus(p.getStatus());
            d.setTotalAmount(p.getTotalAmount());
            d.setUserName(p.getBookingId().getCustomerId().getName());
            dto.add(d);
        }
        return dto;
    }
    
}
