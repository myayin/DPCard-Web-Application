package com.example.DBPROJECT.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="RestaurantTransactionHistory")
public class RestaurantTransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    private String RestaurantTransactionHistoryID;

    private int EmployeeID;

    private String DPCardID;

    private int ContractedMerchantID;

    private Timestamp RestaurantTransactionHistoryDate;

    private BigDecimal Extension;

    private String RestaurantTransactionHistoryOrder;


}
