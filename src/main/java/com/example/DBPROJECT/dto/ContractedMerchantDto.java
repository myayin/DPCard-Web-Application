package com.example.DBPROJECT.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContractedMerchantDto {
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("contractedMerchantEmail")
    private String contractedMerchantEmail;
    @JsonProperty("contractedMerchantPassword")
    private String contractedMerchantPassword;
}
