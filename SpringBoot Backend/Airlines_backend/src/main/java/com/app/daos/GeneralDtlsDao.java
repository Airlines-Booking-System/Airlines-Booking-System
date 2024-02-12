package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.GeneralDetails;

public interface GeneralDtlsDao extends JpaRepository<GeneralDetails,Integer> {
    
}
