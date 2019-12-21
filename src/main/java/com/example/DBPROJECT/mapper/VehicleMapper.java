package com.example.DBPROJECT.mapper;

import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.Resource.VehicleResource;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.dto.VehicleDto;
import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.entity.Vehicle;

public class VehicleMapper {
    public static Vehicle toEntity(VehicleDto vehicleDto) {
        if (vehicleDto == null) {
            return null;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setNumberPlate(vehicleDto.getNumberPlate());


        return vehicle;
    }
    public static VehicleResource toResource(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        VehicleResource vehicleResource = new VehicleResource();
        vehicleResource.setNumberPlate(vehicle.getNumberPlate());
        vehicleResource.setEmployeeId(vehicle.getEmployeeId());
        return vehicleResource;
    }
}
