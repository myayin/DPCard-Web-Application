package com.example.DBPROJECT.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name="DPCard")
public class DPCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    private String DPCardID;

    private int EmployeeID;

    private boolean DPCardType;


}
