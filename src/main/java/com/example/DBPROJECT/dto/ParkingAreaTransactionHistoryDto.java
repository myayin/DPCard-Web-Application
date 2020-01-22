package com.example.DBPROJECT.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParkingAreaTransactionHistoryDto {
    @JsonProperty("EmployeeEmail")
    private String EmployeeEmail;
    @JsonProperty("ContractedMerchantEmail")
    private String ContractedMerchantEmail;
    @JsonProperty("Extension")
    private int Extension;

}
