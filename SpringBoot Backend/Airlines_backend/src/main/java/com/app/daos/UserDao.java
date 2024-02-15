package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails,Integer> {

    @Query(value = "select * from user_details",nativeQuery = true)
    List<UserDetails> findAllUsers();

   
    @Query(value = "update user_details set cpass=:cpass, email=:email, name=:name , role=:role",nativeQuery = true)
    void editProfile(@Param("cpass") String cpass,@Param("email")String email,@Param("name")String name);

    @Query(value="select * from user_details where id=:cid",nativeQuery = true)
    UserDetails findCustomerById(@Param("cid")Integer cid);

    
    
}
