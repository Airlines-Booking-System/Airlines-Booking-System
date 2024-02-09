package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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
@ToString
@EqualsAndHashCode
public class GeneralDetails{
	
	@Id
	private Integer customerId;

	@OneToOne
	@MapsId
	@JoinColumn(name = "customerId")
	private UserDetails customer;
	
	@Column(nullable = false)
	private LocalDate dob;
	
	@Column(nullable = false, length = 100)
	private String address;
	
	@Column(nullable = false, length = 10)
	private String mobileNumber;
	
	@Column(nullable = false, length = 12)
	private String aadhar;
	
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	
	@OneToOne
	private AddressDetails pincode;
}
