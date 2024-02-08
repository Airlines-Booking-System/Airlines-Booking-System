package com.app.entities;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy.Eager;

@Entity
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FlightDetails extends BaseEntity {
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

	@OneToOne
	private LuggageDetails luggageId;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Reviews> reviewId;
}
