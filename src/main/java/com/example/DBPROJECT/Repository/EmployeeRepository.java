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
            value = "INSERT INTO Employee (EmployeeName, EmployeeSurname, EmployeeEmail, EmployeePassword, EmployeePhone, EmployeeBirthday)" +
                    "VALUES (:EName, :ESurname, :EEmail , :EPassword, :EPhone, CONVERT(Date, :EBirthday,1))",
            nativeQuery = true)


    @Transactional
    void insertEmployee(@Param("EName") String EmployeeName,
                        @Param("ESurname") String EmployeeSurname,
                        @Param("EEmail") String EmployeeEmail,
                        @Param("EPassword") String EmployeePassword,
                        @Param("EPhone") String EmployeePhone,
                        @Param("EBirthday") Date EmployeeBirthday);


    @Query(
            value = "SELECT * FROM E.Employee E WHERE EmployeeEmail = :EEmail ", nativeQuery = true
    )

    Employee findWithMail(@Param("EEmail") String EmployeeEmail);

    @Query(
            value = "SELECT E.EmployeeID FROM Employee E WHERE E.EmployeeEmail = :EEmail ", nativeQuery = true
    )

    int findIDWithEmail(@Param("EEmail") String EmployeeEmail);

    @Query(
            value = "SELECT * FROM Employee E WHERE E.EmployeeID = :EID ", nativeQuery = true
    )

    Employee findWithID(@Param("EID") int EmployeeID);

    @Query(
            value = "SELECT E.EmployeeEmail FROM Employee E WHERE E.EmployeeID = :EID ", nativeQuery = true
    )

    String returnEmployeeEmail(@Param("EID") int EmployeeID);


}
