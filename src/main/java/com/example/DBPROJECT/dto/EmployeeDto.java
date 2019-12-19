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
    @JsonProperty("EmployeeName")
    private String EmployeeName;

    @JsonProperty("EmployeeSurname")
    private String EmployeeSurname;

    @JsonProperty("EmployeeEmail")
    private String EmployeeEmail;

    @JsonProperty("EmployeePassword")
    private String EmployeePassword;

    @JsonProperty("EmployeePhone")
    private String  EmployeePhone;

    @JsonProperty("EmployeeBirthday")
    private Date EmployeeBirthday;


}
