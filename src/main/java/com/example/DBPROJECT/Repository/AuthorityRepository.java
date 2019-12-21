package com.example.DBPROJECT.Repository;

import com.example.DBPROJECT.entity.Authority;
import com.example.DBPROJECT.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {



    @Modifying(clearAutomatically = true)
    @Query(
            value=  "update authority  set authority = :authorityType from authority left join employee on authority.employeeid =employee.employeeid where employee_email = :employeeEmail" , nativeQuery = true
    )
    @Transactional
    void updateAuthority(@Param("authorityType") String authorityType,
                         @Param("employeeEmail") String employeeEmail);

    @Query(
            value = "SELECT authority FROM  employee left join authority " +
                    "on employee.employeeid = authority.employeeid  " +
                    "where employee.employee_email= :EEmail",  nativeQuery = true
    )
    String getRole(@Param("EEmail") String EmployeeEmail);

}
