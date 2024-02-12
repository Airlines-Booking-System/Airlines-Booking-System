package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails,Integer> {

    @Query(value = "select * from user_details",nativeQuery = true)
    List<UserDetails> findAllUsers();
    
}
