package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
public class Reviews extends BaseEntity{

    @ManyToOne
    private CustomersDetails customerId;
    
    @ManyToOne
    private FlightDtls flightId;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String review;
}
