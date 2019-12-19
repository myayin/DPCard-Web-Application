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
            value = "SELECT Token FROM ConfirmationToken WHERE EmployeeID :EID", nativeQuery = true
    )
    String findTokenWithID(@Param("EID") int EmployeeID);


    @Query(
            value = "SELECT EmployeeID FROM ConfirmationToken WHERE Token = :token", nativeQuery = true
    )
   int findEmployeeIDWithToken(@Param("token") String Ctoken);

    @Modifying(clearAutomatically = true)
    @Query(
            value = "update ConfirmationToken c set c.TokenStatus = :status where c.Token = :token"
    )
    int updateTokenStatus(@Param("token") String Ctoken,
                          @Param("status") String staus);

}
