package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class PassangerDetails extends BaseEntity{

    @OneToOne
    private BookingDetails bid;
    
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomersDetails customerId;
}
