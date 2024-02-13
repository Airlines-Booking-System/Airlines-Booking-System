package com.app.dtos;


import com.app.entities.StatusEnum;
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
public class PaymentDTO {
    @JsonProperty("flightName")
    private String flightName;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("status")
    private StatusEnum status;
    @JsonProperty("totalAmount")
    private double totalAmount;
}
