package com.app.dtos;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private String name;
	@JsonProperty
	private String flightClass;
	
	@JsonProperty
	private String destination;
	
	@JsonProperty
	private String source;
	
	@JsonProperty
	private LocalDateTime departure;
	
	@JsonProperty
	private LocalDateTime arrival;
}
