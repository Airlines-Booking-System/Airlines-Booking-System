package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.BookFightDao;
import com.app.daos.GeneralDtlsDao;
import com.app.daos.PassengerDao;
import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFightDTO;
import com.app.entities.BookingDetails;
import com.app.entities.GeneralDetails;
import com.app.entities.PassangerDetails;

@Service
public class BookFlightServiceImpl implements BookFlightService {
    @Autowired
    private final BookFightDao dao;
    @Autowired
    private final PassengerDao pdao;
    @Autowired
    private final GeneralDtlsDao gdao;
    @Autowired
    private final ModelMapper modelMapper;

  
    public BookFlightServiceImpl(BookFightDao dao, ModelMapper modelMapper,PassengerDao pdao,GeneralDtlsDao gdao) {
        this.dao = dao;
        this.modelMapper = modelMapper;
        this.pdao=pdao;
        this.gdao=gdao;
    }

    @Override
    public BookingDetails bookFlight(BookFightDTO bookFlightDto) { 
        System.out.println(bookFlightDto);
        BookingDetails bookingDetails = modelMapper.map(bookFlightDto, BookingDetails.class);
        return dao.save(bookingDetails);
    }

    @Override
    public BookFightDTO viewMyBookedFlights(Integer id) {
        BookingDetails d= dao.findById(id).get();
        BookFightDTO dto=modelMapper.map(d, BookFightDTO.class);
        return dto;
    }

    @Override
    public String cancelFlight(Integer id) {
        dao.deleteById(id);
        return "success";
    }

    @Override
    public BookingDetails viewProfile(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public String addPassenger(AddPassengerDTO dto) {
        PassangerDetails passenger=new PassangerDetails();
        passenger.setBookingid(dto.getBookingid());
        passenger.setName(dto.getName());

        GeneralDetails generalDetails=new GeneralDetails();
        generalDetails.setAadhar(dto.getAadhar());
        generalDetails.setAddress(dto.getAddress());
        generalDetails.setCustomer(dto.getCustomer());
        generalDetails.setCustomerId(dto.getCustomerId());
        generalDetails.setDob(dto.getDob());
        generalDetails.setGender(dto.getGender());
        generalDetails.setMobileNumber(dto.getMobileNumber());
        generalDetails.setPincode(dto.getPincode());
        pdao.save(passenger);
        gdao.save(generalDetails);
        return "done";
        
    }
}
