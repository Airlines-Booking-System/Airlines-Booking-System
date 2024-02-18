package com.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.daos.AddressDtlsDao;
import com.app.daos.BookingDtlsDao;
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
import com.app.entities.PassengerDetails;
import com.app.entities.PaymentDetails;
import com.app.entities.UserDetails;

@Service
@Transactional
public class BookFlightServiceImpl implements BookFlightService {

    @Autowired
    private BookingDtlsDao bdao;

    @Autowired
    private AddressDtlsDao adao;

    @Autowired
    private BookingDtlsDao dao;
    @Autowired
    private PassengerDao pdao;
    @Autowired
    private GeneralDtlsDao gdao;
    @Autowired
    private UserDao udao;
    @Autowired
    private FlightDtlsDao fDao;
    @Autowired
    private PaymentDtlsDao paydao;

    @Autowired
    private  ModelMapper modelMapper;

  

    @Override
    public ResponseEntity<BookFlightDTO> bookFlight(BookFlightDTO bookFlightDto) { 
        System.out.println("\n\n----------------\n" + bookFlightDto);
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setFarePrice(bookFlightDto.getFarePrice());
        bookingDetails.setDuration(bookFlightDto.getDuration());
        bookingDetails.setSeatno(bookFlightDto.getSeatno());
        UserDetails customer=udao.findCustomerById(bookFlightDto.getCid());
        bookingDetails.setCustomerId(customer);
        // System.out.println(customer.getName());

        PaymentDetails payment=paydao.findPaymentById(bookFlightDto.getPaymentId());
        bookingDetails.setPaymentID(payment);
        // System.out.println(payment.getStatus());


        FlightDetails flight=fDao.findFlightById(bookFlightDto.getFlightID());
        bookingDetails.setFlightId(flight);
        //  System.out.println(flight.getName());
        
        dao.save(bookingDetails);

        return new ResponseEntity<>(bookFlightDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<BookFlightDTO>> viewMyBookedFlights(Integer id) {
        List<BookingDetails> dtemp= dao.findByCustomerId(udao.findCustomerById(id));

        List<BookFlightDTO> dtoList = new ArrayList<>();
        for(BookingDetails d : dtemp){
            BookFlightDTO dto=new BookFlightDTO();
            dto.setId(d.getId());
            dto.setCid(d.getCustomerId().getId());
            dto.setDuration(d.getDuration());
            dto.setFlightID(d.getFlightId().getId());
            dto.setPaymentId(d.getPaymentID().getId());
            dto.setSeatno(d.getSeatno());
            dto.setFarePrice(d.getFarePrice());
            dtoList.add(dto);
        }
        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<BookFlightDTO> cancelFlight(Integer id) {
        BookingDetails temp = dao.findById(id).orElseThrow();
        // BookFlightDTO flightToBeDeleted = new BookFlightDTO();
        // flightToBeDeleted.setCid(temp.getCustomerId().getId());
        // flightToBeDeleted.setDuration(temp.getDuration());
        // flightToBeDeleted.setFarePrice(temp.getFarePrice());
        // flightToBeDeleted.setFlightID(temp.getFlightId().getId());
        // flightToBeDeleted.setId(temp.getId());
        // flightToBeDeleted.setPaymentId(temp.getPaymentID().getId());
        // flightToBeDeleted.setSeatno(temp.getSeatno());
        bdao.delete(temp);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    public ResponseEntity<ViewProfileDTO> viewProfile(Integer id) {
        UserDetails details= udao.findById(id).get();
        GeneralDetails generalDetails=gdao.findByCustomerId(id);
        ViewProfileDTO dto=modelMapper.map(details, ViewProfileDTO.class);
        dto.setAadhar(generalDetails.getAadhar());
        dto.setAddress(generalDetails.getAddress());
        dto.setDob(generalDetails.getDob());
        dto.setMobileNumber(generalDetails.getMobileNumber());
        dto.setPincode(generalDetails.getPincode());
        dto.setCustomerId(details.getId());
        dto.setGender(generalDetails.getGender());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<AddPassengerDTO> addPassenger(AddPassengerDTO dto, Integer cid) {
        PassengerDetails passenger= modelMapper.map(dto, PassengerDetails.class);
        System.out.println("\n\n Mapped add passenger dto to passenger details entity: \n\n" + passenger);        
        pdao.save(passenger);
        System.out.println("\n\n Passanger added, mapping the passenger to a customer: \n\n");
        UserDetails customer = udao.findById(cid).orElseThrow();
        List<PassengerDetails> passList = customer.getPassengerId();
        passList.add(passenger);
        customer.setPassengerId(passList);
        System.out.println("\n\n mapped\n\n");
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ViewProfileDTO> editProfile(ViewProfileDTO dto, Integer id) {
        UserDetails userToUpdate= udao.findCustomerById(id);
        GeneralDetails generalDetails= gdao.findByCustomerId(id);
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

        gdao.editProfile(generalDetails.getAadhar(),generalDetails.getAddress(),generalDetails.getDob(),generalDetails.getGender().name(), generalDetails.getMobileNumber(),generalDetails.getPincode().getPincode());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> viewPassengers(Integer cid) {
        List<Integer> idList = udao.findAllPassengersByCid(cid);
        List<PassengerDetails> passList = new ArrayList<>();
        for(Integer id : idList){
            passList.add(pdao.findById(id).orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.OK).body(passList);
    }
}
