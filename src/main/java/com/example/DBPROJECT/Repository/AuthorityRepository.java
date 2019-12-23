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
            value=  "update authority  set authority = :authorityType " +
                    "from authority left join employee " +
                    "on authority.employeeid =employee.employeeid w" +
                    "here employee_email = :employeeEmail" , nativeQuery = true
    )


    @Transactional
    void updateAuthority(@Param("authorityType") String authorityType,
                         @Param("employeeEmail") String employeeEmail);

    @Modifying(clearAutomatically = true)
    @Query(
            value=  "update authority  set authority = :authorityType from authority left join contracted_merchant on authority.contracted_merchantid =contracted_merchant.contracted_merchantid where contracted_merchant_email = :contractedEmail" , nativeQuery = true
    )


    @Transactional
    void updateAuthorityForMerchant(@Param("authorityType") String authorityType,
                         @Param("contractedEmail") String contractedEmail);


    @Query(
            value = "SELECT authority FROM  employee left join authority " +
                    "on employee.employeeid = authority.employeeid  " +
                    "where employee.employee_email= :EEmail",  nativeQuery = true
    )
    String getRole(@Param("EEmail") String EmployeeEmail);

}
