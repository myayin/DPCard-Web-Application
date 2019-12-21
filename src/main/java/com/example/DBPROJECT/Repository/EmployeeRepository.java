package com.example.DBPROJECT.Repository;

import com.example.DBPROJECT.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;

;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Modifying(clearAutomatically = true)
    @Query(
            value = "INSERT INTO employee (employee_name, employee_surname, employee_email, employee_password, employee_phone)" +
                    "VALUES (:EName, :ESurname, :EEmail , :EPassword, :EPhone)",
            nativeQuery = true)


    @Transactional
    void insertEmployee(@Param("EName") String EmployeeName,
                        @Param("ESurname") String EmployeeSurname,
                        @Param("EEmail") String EmployeeEmail,
                        @Param("EPassword") String EmployeePassword,
                        @Param("EPhone") String EmployeePhone);


    @Query(
            value = "SELECT * FROM employee WHERE employee_email = :EEmail ", nativeQuery = true
    )

    Employee findWithMail(@Param("EEmail") String EmployeeEmail);

    @Query(
            value = "SELECT employeeid FROM employee WHERE employee_email = :EEmail ", nativeQuery = true
    )

    int findIDWithEmail(@Param("EEmail") String EmployeeEmail);

    @Query(
            value = "SELECT * FROM employee WHERE employeeid = :EID ", nativeQuery = true
    )

    Employee findWithID(@Param("EID") int EmployeeID);

    @Query(
            value = "SELECT employee_email FROM employee WHERE employeeid = :EID ", nativeQuery = true
    )

    String returnEmployeeEmail(@Param("EID") int EmployeeID);


}
