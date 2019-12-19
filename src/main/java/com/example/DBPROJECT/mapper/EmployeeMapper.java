package com.example.DBPROJECT.mapper;

import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.entity.Employee;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employee.setEmployeePassword(employeeDto.getEmployeePassword());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeSurname(employeeDto.getEmployeeSurname());
        employee.setEmployeeBirthday(employeeDto.getEmployeeBirthday());
        employee.setEmployeePhone(employeeDto.getEmployeePhone());

        return employee;
    }
    public static EmployeeResource toResource(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeResource employeeResource = new EmployeeResource();
        employeeResource.setEmployeeID(employee.getEmployeeID());
        employeeResource.setEmployeeEmail(employee.getEmployeeEmail());
        return employeeResource;
    }
}
