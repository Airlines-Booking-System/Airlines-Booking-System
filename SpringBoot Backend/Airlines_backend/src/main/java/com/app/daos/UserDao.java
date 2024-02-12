package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails,Integer> {
    
}
