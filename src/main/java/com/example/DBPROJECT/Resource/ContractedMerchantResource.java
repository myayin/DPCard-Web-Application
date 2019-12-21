package com.example.DBPROJECT.Resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Resource;

@Getter
@Setter
@Resource
public class ContractedMerchantResource {

    private String contractedMerchantEmail;
}
