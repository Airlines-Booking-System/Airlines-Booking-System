package com.app.dtos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.entities.GeneralDetails;
import com.app.entities.PassangerDetails;
import com.app.entities.RoleEnum;
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
public class UserDTO {
    @JsonProperty
	private String name;
    @JsonProperty
	private String email;
    @JsonProperty
	private String cpass;
    @JsonProperty
	private RoleEnum role;
}

