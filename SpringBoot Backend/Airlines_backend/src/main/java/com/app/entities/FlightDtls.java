package com.app.entities;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class FlightDtls extends BaseEntity {
	@Column(nullable = false, length = 100)
	@JsonProperty
	private String name;
	
	@Column(nullable = false, length = 50)
	@JsonProperty
	private String flightClass;
	
	@Column(nullable = false, length = 100)
	@JsonProperty
	private String destination;
	
	@Column(nullable = false, length = 100)
	@JsonProperty
	private String source;
	
	@Column(nullable = false)
	@JsonProperty
	private LocalDateTime departure;
	
	@Column(nullable = false)
	@JsonProperty
	private LocalDateTime arrival;
}
