package com.app.dtos;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class BookFlightDTO {
    
    @JsonProperty("cid")
    private Integer cid;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("flightID")
    private Integer flightID;

    @JsonProperty("farePrice")
    private double farePrice;

     @JsonFormat(pattern = "HH:mm:ss")
    @JsonProperty("duration")
    private LocalTime duration;

    @JsonProperty("Seatno")
    private String Seatno;

    @JsonProperty("paymentId")
    private Integer paymentId;
    
}
