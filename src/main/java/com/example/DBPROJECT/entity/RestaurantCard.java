package com.example.DBPROJECT.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="RestaurantCard")
public class RestaurantCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    private String RestaurantCardID;

    private BigDecimal RestaurantCardNumber;

    private BigDecimal Balance;


}
