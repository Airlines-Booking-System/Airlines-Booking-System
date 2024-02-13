package com.app.dtos;

import java.time.LocalDate;


import com.app.entities.AddressDetails;
import com.app.entities.BookingDetails;
import com.app.entities.GenderEnum;
import com.app.entities.UserDetails;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@AllArgsConstructor
public class AddPassengerDTO {
    @JsonProperty("customerId")
    private Integer customerId;
    @JsonProperty("customer")
    private UserDetails customer;
    @JsonProperty("dob")
    private LocalDate dob;
    @JsonProperty("address")
	private String address;
	@JsonProperty("mobileNumber")
	private String mobileNumber;
	@JsonProperty("aadhar")
	private String aadhar;
    @JsonProperty("gender")
	private GenderEnum gender;
	@JsonProperty("pincode")
	private AddressDetails pincode;
    @JsonProperty("bookingId")
    private BookingDetails bookingid;
    @JsonProperty("name")
    private String name;
}
