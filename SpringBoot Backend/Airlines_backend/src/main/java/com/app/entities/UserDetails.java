package com.app.entities;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserDetails extends BaseEntity /*THIS IS AUTOMATICALLY IMPLEMENTED WITH SERIALIZABLE DUE TO INHERITANCE (BASE ENTITY)*/{
	
	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false,length=50)
	private String email;

	@Column(nullable = false, length = 50)
	private String cpass;

	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_details_id")  // Specify the foreign key column in PassangerDetails
    private List<PassangerDetails> passengers;

	@OneToOne(mappedBy = "customer")
	private GeneralDetails generalDetails;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
}
