package com.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Signup {
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	@NotBlank(message = "First Name required")
	private String firstName;
	@Email(message = "Invalid Email!!!")
	private String email;
	private String password;
	private UserRole role;
	public Signup(String firstName, 
			String email, String password, UserRole role) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public String getEmail() {
		return email;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
