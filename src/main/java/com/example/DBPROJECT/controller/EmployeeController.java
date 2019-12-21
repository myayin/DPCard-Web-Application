package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;




    @RequestMapping(value="/register",method = RequestMethod.POST)
    public EmployeeResource registerUser(@RequestBody EmployeeDto employeeDto) {

        return employeeService.save(EmployeeMapper.toEntity(employeeDto));

    }
    @GetMapping("/confirm-register")
    public EmployeeResource confirmRegister(@RequestParam("token") String confirmationToken) {
        return employeeService.confirmRegister(confirmationToken);
    }
   /* @GetMapping("/confirm-register")
    public EmployeeResource addVehicle(@RequestParam("number-plate") String numberPlate,@RequestParam("employee-email") String employeeEmail ) {
        return employeeService.addVehicle(numberPlate, employeeEmail);
    }*/

}

