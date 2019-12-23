package com.example.DBPROJECT.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class RestaurantTransactionHistoryDto {
    @JsonProperty("EmployeeEmail")
    private String EmployeeEmail;
    @JsonProperty("ContractedMerchantEmail")
    private String ContractedMerchantEmail;
    @JsonProperty("Extension")
    private int Extension;
    @JsonProperty("RestaurantTransactionHistoryOrder")
    private String RestaurantTransactionHistoryOrder;



}
