package com.example.DBPROJECT.services;


import com.example.DBPROJECT.Repository.VehicleRepository;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.Resource.VehicleResource;
import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.entity.Vehicle;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.normalizer.VersionInfo;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    public VehicleResource addVehicle(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findWithNumberPlate(vehicle.getNumberPlate());

        if (existingVehicle != null) {
            throw new RuntimeException("VEHICLE_ALREADY_EXISTS");
        }
        vehicleRepository.insertVehicle(vehicle.getNumberPlate());
        return VehicleMapper.toResource(vehicle);
    }
}
