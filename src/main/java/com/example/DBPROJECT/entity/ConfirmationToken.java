package com.example.DBPROJECT.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name="ConfirmationToken")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ConfirmationTokenID;

    private int EmployeeID;

    private int ContractedMerchantID;

    private String Token;

    private String TokenStatus;

    //private Timestamp CreateDate;




}
