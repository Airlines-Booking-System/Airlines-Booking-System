package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@ToString
@EqualsAndHashCode
public class AddressDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pincode;

    @Column(nullable = false, length = 50)
    private String state;
    
    @Column(nullable = false, length = 50)
    private String city;
}
