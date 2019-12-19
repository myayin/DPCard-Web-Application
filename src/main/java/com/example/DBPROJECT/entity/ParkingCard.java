package com.example.DBPROJECT.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="ParkingCard")
public class ParkingCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    private String ParkingCardID;

    private BigDecimal ParkingCardNumber;

    private BigDecimal Balance;

    private String NumberPlate;

}
