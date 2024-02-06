package com.app.entities;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class FlightDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String flightClass;
	
	@Column(nullable = false, length = 100)
	private String destination;
	
	@Column(nullable = false, length = 100)
	private String source;
	
	@Column(nullable = false)
	private LocalDateTime departure;
	
	@Column(nullable = false)
	private LocalDateTime arrival;
}
