package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.services.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeSevice employeeService;




    @RequestMapping(value="/register",method = RequestMethod.POST)
    public EmployeeResource registerUser(@RequestBody EmployeeDto employeeDto) {

        return employeeService.save(EmployeeMapper.toEntity(employeeDto));

    }
    @GetMapping("/confirm-register")
    public EmployeeResource confirmRegister(@RequestParam("token") String confirmationToken) {
        return employeeService.confirmRegister(confirmationToken);
    }

}

