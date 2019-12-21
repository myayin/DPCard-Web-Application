package com.example.DBPROJECT.Repository;

import com.example.DBPROJECT.entity.ConfirmationToken;
import com.example.DBPROJECT.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    @Query(
            value = "SELECT token FROM confirmation_token WHERE employeeid :EID", nativeQuery = true
    )
    String findTokenWithID(@Param("EID") int EmployeeID);


    @Query(
            value = "SELECT employeeid FROM confirmation_token WHERE token = :token", nativeQuery = true
    )
   int findEmployeeIDWithToken(@Param("token") String Ctoken);

    @Modifying(clearAutomatically = true)
    @Query(
          value=  "update confirmation_token  set token_status = :status where token = :token" , nativeQuery = true
    )
    void updateTokenStatus(@Param("token") String token,
                          @Param("status") String status);

}
