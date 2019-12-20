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

    private boolean EmployeeStatus;

    private String EmployeeName;

    private String EmployeeSurname;

    private String EmployeeEmail;

    private String EmployeePassword;

    private String  EmployeePhone;

    /*private Date employeeBirthday;

    private int employeeAge;*/






}
