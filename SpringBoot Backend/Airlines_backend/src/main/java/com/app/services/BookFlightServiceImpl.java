package com.app.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.BookFightDao;
import com.app.daos.FlightDtlsDao;
import com.app.daos.GeneralDtlsDao;
import com.app.daos.PassengerDao;
import com.app.daos.PaymentDtlsDao;
import com.app.daos.UserDao;
import com.app.dtos.AddPassengerDTO;
import com.app.dtos.BookFlightDTO;
import com.app.dtos.ViewProfileDTO;
import com.app.entities.BookingDetails;
import com.app.entities.FlightDetails;
import com.app.entities.GeneralDetails;
import com.app.entities.PassangerDetails;
import com.app.entities.PaymentDetails;
import com.app.entities.UserDetails;

@Service
@Transactional
public class BookFlightServiceImpl implements BookFlightService {
    @Autowired
    private  BookFightDao dao;
    @Autowired
    private  PassengerDao pdao;
    @Autowired
    private  GeneralDtlsDao gdao;
    @Autowired
    private UserDao udao;
    @Autowired
    private FlightDtlsDao fDao;
    @Autowired
    private PaymentDtlsDao paydao;

    @Autowired
    private  ModelMapper modelMapper;

  

    @Override
    public BookingDetails bookFlight(BookFlightDTO bookFlightDto) { 
        System.out.println(bookFlightDto);

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setFarePrice(bookFlightDto.getFarePrice());
        bookingDetails.setDuration(bookFlightDto.getDuration());
        bookingDetails.setSeatno(bookFlightDto.getSeatno());
        UserDetails customer=udao.findCustomerById(bookFlightDto.getCid());
        bookingDetails.setCustomerId(customer);
        System.out.println(customer.getName());

        PaymentDetails payment=paydao.findPaymentById(bookFlightDto.getPaymentId());
        bookingDetails.setPaymentID(payment);
        System.out.println(payment.getStatus());


        FlightDetails flight=fDao.findFlightById(bookFlightDto.getFlightID());
        bookingDetails.setFlightId(flight);
         System.out.println(flight.getName());

        return dao.save(bookingDetails);

    }

    @Override
    public BookFlightDTO viewMyBookedFlights(Integer id) {
        BookingDetails d= dao.findById(id).get();
        BookFlightDTO dto=new BookFlightDTO();
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
