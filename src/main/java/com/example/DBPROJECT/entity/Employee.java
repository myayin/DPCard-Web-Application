package com.example.DBPROJECT.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;

/**
 * Created by Merve Yayın on 05.08.2019.
 */
@Data
@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EmployeeID;
    @Column
    private boolean EmployeeStatus;
   @Column
    private String EmployeeName;
    @Column
    private String EmployeeSurname;
    @Column
    private String EmployeeEmail;
    @Column
    private String EmployeePassword;
    @Column
    private String  EmployeePhone;

    /*private Date employeeBirthday;

    private int employeeAge;*/






}
