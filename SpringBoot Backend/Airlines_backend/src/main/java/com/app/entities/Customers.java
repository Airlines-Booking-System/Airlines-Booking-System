package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

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
public class Customers extends BaseEntity /*THIS IS AUTOMATICALLY IMPLEMENTED WITH SERIALIZABLE DUE TO INHERITANCE (BASE ENTITY)*/{
	
	@Column(nullable = false, length = 50)
	private String cname;
	@Column(nullable = false, length = 50)
	private String cpass;
}
