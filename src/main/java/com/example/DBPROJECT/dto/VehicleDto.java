package com.example.DBPROJECT.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleDto {
    @JsonProperty("NumberPlate")
    private String NumberPlate;
}
