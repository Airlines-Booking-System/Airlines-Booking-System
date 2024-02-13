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
        FlightDetails details=modelMapper.map(flightToAdd, FlightDetails.class);
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
