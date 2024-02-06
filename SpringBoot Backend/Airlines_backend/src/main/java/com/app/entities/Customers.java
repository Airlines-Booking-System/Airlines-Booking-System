package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
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
public class Customers extends BaseEntity{
	
	@Column(nullable = false, length = 50)
	private String cname;
	@Column(nullable = false, length = 50)
	private String cpass;
}
