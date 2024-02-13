package com.app.daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.FlightDetails;
import com.app.entities.PaymentDetails;
import com.app.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails,Integer> {

    @Query(value = "select * from user_details",nativeQuery = true)
    List<UserDetails> findAllUsers();

    @Query(value="insert into flight_details values(default,:arrival,:departure,:destination,:flightclass,:name,:source)" ,nativeQuery = true)
    void addFlight(@Param("arrival") LocalDateTime localDateTime,@Param("departure")LocalDateTime localDateTime2,@Param("destination")String destination,@Param("flightclass")String flightclass,@Param("name") String name,@Param("source") String source);

    @Query(value="select * from flight_details where id=:id",nativeQuery = true)
    FlightDetails findFlightById(@Param("id")Integer id);

    @Query(value="")
    String editFlight(FlightDetails details);

    @Query(value = "update user_details set cpass=:cpass, email=:email, name=:name , role=:role",nativeQuery = true)
    void editProfile(@Param("cpass") String cpass,@Param("email")String email,@Param("name")String name);

    @Query(value="select * from payment_details",nativeQuery = true)
    List<PaymentDetails> getAllPayments();
    
}
