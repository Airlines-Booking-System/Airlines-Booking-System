package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.PassangerDetails;

public interface PassengerDao extends JpaRepository<PassangerDetails,Integer>{
    
}
