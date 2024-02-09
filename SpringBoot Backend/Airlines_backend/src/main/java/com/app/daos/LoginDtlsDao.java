package com.app.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.UserDetails;

public interface LoginDtlsDao {
    @Query(value="select * from user_details where email=:email and cpass=:password", nativeQuery = true)
    UserDetails getUser(@Param("email")String email, @Param("password")String password);

    
} 
