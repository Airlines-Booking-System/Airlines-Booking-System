package com.app.daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.FlightDetails;

public interface FlightDtlsDao extends JpaRepository<FlightDetails, Integer> {
    @Query(value = "select * from flight_details where source = :toCity and destination = :fromCity and departure >= :departure", nativeQuery = true)
    List<FlightDetails> findByCityAndDate(@Param("toCity") String toCity,@Param("fromCity") String fromCity, @Param("departure") LocalDateTime departure);

}
