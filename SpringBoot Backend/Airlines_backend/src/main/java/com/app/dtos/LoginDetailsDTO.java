package com.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoginDetailsDTO {
    @Email
    @JsonProperty("email")
    private String email;
    
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$",
        message = "Password must be at least 8 characters long and contain at least one capital letter, one number, and one special character."
    )
    @JsonProperty("password")
    private String password;

}
