package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.BookFightDao;
import com.app.daos.GeneralDtlsDao;
import com.app.daos.PassengerDao;
import com.app.daos.UserDao;
import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFightDTO;
import com.app.dtos.ViewProfileDTO;
import com.app.entities.BookingDetails;
import com.app.entities.GeneralDetails;
import com.app.entities.PassangerDetails;
import com.app.entities.UserDetails;

@Service
public class BookFlightServiceImpl implements BookFlightService {
    @Autowired
    private final BookFightDao dao;
    @Autowired
    private final PassengerDao pdao;
    @Autowired
    private final GeneralDtlsDao gdao;
    @Autowired
    private UserDao udao;

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
        BookFightDTO dto=new BookFightDTO();
        dto.setId(d.getId());
        dto.setCid(d.getCustomerId().getId());
        dto.setDuration(d.getDuration());
        dto.setFlightID(d.getFlightId().getId());
        dto.setPaymentId(d.getPaymentID().getId());
        dto.setSeatno(d.getSeatno());
        dto.setFarePrice(d.getFarePrice());
        return dto;
    }

    @Override
    public String cancelFlight(Integer id) {
        dao.deleteById(id);
        return "success";
    }

    @Override
    public ViewProfileDTO viewProfile(Integer id) {
        UserDetails details= udao.findById(id).get();
        GeneralDetails generalDetails=gdao.findByCustomerId(id);
        ViewProfileDTO dto=modelMapper.map(details, ViewProfileDTO.class);
        dto.setAadhar(generalDetails.getAadhar());
        dto.setAddress(generalDetails.getAddress());
        dto.setDob(generalDetails.getDob());
        dto.setMobileNumber(generalDetails.getMobileNumber());
        dto.setPincode(generalDetails.getPincode());
        return dto;
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

    @Override
    public void editProfile(ViewProfileDTO dto) {
        UserDetails userToUpdate=new UserDetails();
        GeneralDetails generalDetails=new GeneralDetails();
        userToUpdate.setCpass(dto.getCpass());
        userToUpdate.setEmail(dto.getEmail());
        userToUpdate.setName(dto.getName());

        udao.editProfile(userToUpdate.getCpass(),userToUpdate.getEmail(),userToUpdate.getName());


        generalDetails.setAadhar(dto.getAadhar());
        generalDetails.setAddress(dto.getAddress());
        generalDetails.setDob(dto.getDob());
        generalDetails.setGender(dto.getGender());
        generalDetails.setMobileNumber(dto.getMobileNumber());
        generalDetails.setPincode(dto.getPincode());

        gdao.editProfile(generalDetails.getAadhar(),generalDetails.getAddress(),generalDetails.getDob(),generalDetails.getGender(),generalDetails.getMobileNumber(),generalDetails.getPincode().getPincode());

    }
}
