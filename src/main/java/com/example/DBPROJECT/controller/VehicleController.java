package com.example.DBPROJECT.controller;


import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.Resource.VehicleResource;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.dto.VehicleDto;
import com.example.DBPROJECT.entity.Vehicle;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.mapper.VehicleMapper;
import com.example.DBPROJECT.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public VehicleResource addVehicle(@RequestBody VehicleDto vehicleDto) {

        return vehicleService.addVehicle(VehicleMapper.toEntity(vehicleDto));

    }
}
