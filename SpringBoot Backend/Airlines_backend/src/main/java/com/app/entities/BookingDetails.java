package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private CustomersDetails customerId;

    @OneToOne
    private PaymentDetails paymentID;

    @ManyToOne
    @Column(nullable = false)
    private FlightDtls flightId;

    @Column(nullable = false)
    private double farePrice;

    @Column(nullable = false)
    private LocalTime duration;

    @Column(nullable = false)
    private String seatNo;
}
