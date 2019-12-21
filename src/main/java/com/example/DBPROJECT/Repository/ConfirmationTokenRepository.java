package com.example.DBPROJECT.Repository;

import com.example.DBPROJECT.entity.ConfirmationToken;
import com.example.DBPROJECT.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    @Query(
            value = "SELECT token FROM employee left join confirmation_token on employee.employeeid=confirmation_token.employeeid where employee.employee_email= :EEmail", nativeQuery = true
    )
    String findTokenWithEmail(@Param("EEmail") String EmployeeEmail);


    @Query(
            value = "SELECT employeeid FROM confirmation_token WHERE token = :token", nativeQuery = true
    )
   int findEmployeeIDWithToken(@Param("token") String Ctoken);

    @Modifying(clearAutomatically = true)
    @Query(
          value=  "update confirmation_token  set token_status = :status where token = :token" , nativeQuery = true
    )
    @Transactional
    void updateTokenStatus(@Param("token") String token,
                          @Param("status") String status);

}
