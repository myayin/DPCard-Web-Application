package com.example.DBPROJECT.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;

@Getter
@Setter
@ToString
public class EmployeeDto {
    @JsonProperty("employeeName")
    private String EmployeeName;

    @JsonProperty("employeeSurname")
    private String EmployeeSurname;

    @JsonProperty("employeeEmail")
    private String EmployeeEmail;

    @JsonProperty("employeePassword")
    private String EmployeePassword;

    @JsonProperty("employeePhone")
    private String  EmployeePhone;

  /*  @JsonProperty("EmployeeBirthday")
    private Date EmployeeBirthday;*/



}
