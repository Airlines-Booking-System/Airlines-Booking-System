package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeatDetails extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightDetails flightId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingDetails bookingId;

    @Column(nullable = false)
    private String seatNo;

    private boolean isAvailable;
}
