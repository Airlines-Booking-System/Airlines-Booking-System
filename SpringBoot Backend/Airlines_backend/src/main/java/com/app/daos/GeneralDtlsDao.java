package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.GeneralDetails;

public interface GeneralDtlsDao extends JpaRepository<GeneralDetails,Integer> {

    @Query(value = "select * from general_details where customer_id=:id",nativeQuery = true)
    GeneralDetails findByCustomerId(@Param("id")Integer id);
    
}
