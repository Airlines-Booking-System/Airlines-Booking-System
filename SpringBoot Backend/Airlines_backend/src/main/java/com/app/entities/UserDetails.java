package com.app.entities;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
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
public class UserDetails extends BaseEntity /*THIS IS AUTOMATICALLY IMPLEMENTED WITH SERIALIZABLE DUE TO INHERITANCE (BASE ENTITY)*/{
	
	@Column(nullable = false, length = 50)
	private String cname;
	
	@Column(nullable = false, length = 50)
	private String cpass;

	@OneToMany(mappedBy = "customerId")
	private List<PassangerDetails> passangers;

	@OneToOne(mappedBy = "customer")
	private GeneralDetails generalDetails;
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
}
