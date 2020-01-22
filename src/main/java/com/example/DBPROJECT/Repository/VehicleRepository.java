package com.example.DBPROJECT.Repository;

import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VehicleRepository extends JpaRepository<Employee, String> {
    @Query(
            value = "SELECT * FROM vehicle WHERE number_plate = :numberPlate ", nativeQuery = true
    )
    Vehicle findWithNumberPlate(@Param("numberPlate") String numberPlate);

    @Modifying(clearAutomatically = true)
    @Query(
            value = "INSERT INTO vehicle (number_plate)" +
                    "VALUES (:numberPlate)",
            nativeQuery = true)


    @Transactional
    void insertVehicle(@Param("numberPlate") String numberPlate);

    @Modifying(clearAutomatically = true)
    @Query(
            value=  "update vehicle  set employeeid = :employeeid where number_plate = :numberPlate" , nativeQuery = true
    )
    @Transactional
    void updateVehicle(@Param("employeeid") int employeeid,
                           @Param("numberPlate") String numberPlate);
}
