package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.BookFightDao;
import com.app.dtos.BookFightDTO;
import com.app.entities.BookingDetails;

@Service
public class BookFlightServiceImpl implements BookFlightService {
    @Autowired
    private BookFightDao dao;

    private ModelMapper modelMapper;
    @Override
    public BookingDetails bookFlight(BookFightDTO bookFlightDto) { 
        BookingDetails d=modelMapper.map(bookFlightDto, BookingDetails.class);
        return dao.save(d);
    }
    
}
