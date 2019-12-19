package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.services.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class EmployeeController {
    @Autowired
    private EmployeeSevice employeeSevice;

    @GetMapping("/deneme")
    public String homePage(Model model) {
        model.addAttribute("appName", "appName");
        return "home";
    }

    @PostMapping("/register")
    public EmployeeResource registerUser(@RequestBody EmployeeDto employeeDto) {
        return employeeSevice.save(EmployeeMapper.toEntity(employeeDto));
    } }
