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
            value = "SELECT token FROM contracted_merchant left join confirmation_token on contracted_merchant.contracted_merchantid=confirmation_token.contracted_merchantid where contracted_merchant.contracted_merchant_email= :EEmail", nativeQuery = true
    )
    String findTokenWithEmailForMercahnt(@Param("EEmail") String EmployeeEmail);

    @Query(
            value = "SELECT employeeid FROM confirmation_token WHERE token = :token", nativeQuery = true
    )
   int findEmployeeIDWithToken(@Param("token") String Ctoken);

    @Query(
            value = "SELECT contracted_merchantid FROM confirmation_token WHERE token = :token", nativeQuery = true
    )
    int findMerchantIDWithToken(@Param("token") String Ctoken);


    @Modifying(clearAutomatically = true)
    @Query(
          value=  "update confirmation_token  set token_status = :status where token = :token" , nativeQuery = true
    )
    @Transactional
    void updateTokenStatus(@Param("token") String token,
                          @Param("status") String status);

    @Modifying(clearAutomatically = true)
    @Query(
            value=  "update employee  set employee_confirmed = '1'  from employee left join confirmation_token where confirmation_token.token = :token" , nativeQuery = true
    )
    @Transactional
    void confirmEmployee(@Param("token") String token);

    @Modifying(clearAutomatically = true)
    @Query(
            value=  "update contracted_merchant  set contracted_merchant_confirmed = '1'  " +
                    "from contracted_merchant " +
                    "left join confirmation_token " +
                    "on contracted_merchant.contracted_merchantid=confirmation_token.contracted_merchantid " +
                    "where token = :token" , nativeQuery = true
    )
    @Transactional
    void confirmMerchant(@Param("token") String token);


}
