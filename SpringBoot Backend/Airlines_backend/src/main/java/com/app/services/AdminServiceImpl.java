package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.UserDao;
import com.app.dtos.FlightDTO;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFlight'");
    }
    
}
