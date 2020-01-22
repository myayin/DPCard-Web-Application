package com.example.DBPROJECT.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="ParkingAreaTransactionHistory")
public class ParkingAreaTransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    private String ParkingAreaTransactionHistoryID;

    private int EmployeeID;

    private String DPCardID;

    private int ContractedMerchantID;

    private int Extension;

    private Timestamp EntryDate;

    private Timestamp LeaveDate;

}
