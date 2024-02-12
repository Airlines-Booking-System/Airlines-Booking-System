package com.app.entities;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookingDetails extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "customerId")
    private UserDetails customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId")
    private PaymentDetails paymentID;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private FlightDetails flightId;

    
    @Column(nullable = false)
    private double farePrice;

    @Column(nullable = true)
    private LocalTime duration;

    @Column(nullable = false)
    private String seatno;
}
