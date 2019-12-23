package com.example.DBPROJECT.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ContractedMerchant")
public class ContractedMerchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ContractedMerchantID;

    private boolean ContractedMerchantStatus;

    private String CompanyName;

    private String ContractedMerchantEmail;

    private String ContractedMerchantPassword;

}
