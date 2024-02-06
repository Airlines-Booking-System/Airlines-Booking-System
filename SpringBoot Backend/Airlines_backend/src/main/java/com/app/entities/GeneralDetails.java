package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class GeneralDetails{
	
	@OneToOne
	private Customers customer;
	
	@OneToMany
	private List<PassangerDetails> passangers;
	
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
	
//	@OneToOne
//	private Integer pincode;
}
