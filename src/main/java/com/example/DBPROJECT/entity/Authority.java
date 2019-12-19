package com.example.DBPROJECT.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name="Authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    private String AuthorityID;

    private int EmployeeID;

    private int ContractedMerchantID;

    private String Authority;



}
