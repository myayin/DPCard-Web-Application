package com.example.DBPROJECT.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name="Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    private String VehicleID;

    private int EmployeeId;

    private String NumberPlate;
}
