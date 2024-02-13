package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.FlightDtlsDao;
import com.app.daos.PaymentDtlsDao;
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
    @Autowired
    private FlightDtlsDao fDao;
    @Autowired 
    private PaymentDtlsDao pdao;

    @Autowired
    private ModelMapper modelMapper;
    @Override

    public List<UserDetails> viewAllUsers() {
        return uDao.findAllUsers();
    }
    @Override
    public String addFlight(FlightDTO flightToAdd) {
        FlightDetails details=new FlightDetails();
        details.setArrival(flightToAdd.getArrival());
        details.setDeparture(flightToAdd.getDeparture());
        details.setDestination(flightToAdd.getDestination());
        details.setFlightClass(flightToAdd.getFlightClass());
        details.setName(flightToAdd.getName());
        details.setSource(flightToAdd.getSource());
        fDao.save(details);
        return "added successfully";
    }
    @Override
    public String deleteFlight(Integer id) {
        uDao.deleteById(id);
        return "deleted succesfully";

    }
    @Override
    public FlightDTO getFlightById(Integer id) {
        FlightDetails flight= fDao.findFlightById(id);
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
    public String editFlight(FlightDTO flight,Integer id) {
        FlightDetails details=new FlightDetails();
        details.setArrival(flight.getArrival());
        details.setDeparture(flight.getDeparture());
        details.setDestination(flight.getDestination());
        details.setFlightClass(flight.getFlightClass());
        details.setName(flight.getName());
        details.setSource(flight.getSource());
        fDao.editFlight(flight.getArrival(),flight.getDeparture(),flight.getDestination(),flight.getFlightClass(),flight.getName(),flight.getSource(),id);
        return "edited successfully";
    }
    @Override
    public List<PaymentDTO> allPayments() {
        List<PaymentDetails> list=pdao.getAllPayments();
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
