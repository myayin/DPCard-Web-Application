package com.example.DBPROJECT.Repository;

import com.example.DBPROJECT.entity.ContractedMerchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContractedMerchantRepository extends JpaRepository<ContractedMerchant, String> {
    @Modifying(clearAutomatically = true)
    @Query(
            value = "INSERT INTO contracted_merchant (company_name, contracted_merchant_email, contracted_merchant_password, contracted_merchant_status, contracted_merchant_type)" +
                    "VALUES (:CName, :CMail, :CPassword ,'1', :CType)",
            nativeQuery = true)


    @Transactional
    void insertContractedMerchant(@Param("CName") String companyName,
                        @Param("CMail") String companyEmail,
                        @Param("CPassword") String companyPassword,
                        @Param("CType") boolean companyType);

    @Query(
            value = "SELECT contracted_merchantid FROM contracted_merchant WHERE contracted_merchant_email = :EEmail ", nativeQuery = true
    )

    int findIDWithEmail(@Param("EEmail") String contractedMerchantEmail);

    @Query(
            value = "SELECT * FROM contracted_merchant WHERE contracted_merchant_email = :EEmail ", nativeQuery = true
    )

    ContractedMerchant findMerchantWithEmail(@Param("EEmail") String contractedMerchantEmail);

    @Query(
            value = "SELECT company_name FROM contracted_merchant WHERE contracted_merchant_email = :EEmail ", nativeQuery = true
    )

    String getCompanyName(@Param("EEmail") String contractedMerchantEmail);

    @Query(
            value = "SELECT * FROM contracted_merchant WHERE contracted_merchantid = :CId ", nativeQuery = true
    )

    ContractedMerchant getMerchantWithID(@Param("CId") int contractedMerchantId);

    @Query(
            value = "SELECT contracted_merchant_email FROM contracted_merchant WHERE contracted_merchantid = :CId ", nativeQuery = true
    )

    String getEmailWithId(@Param("CId") int contractedMerchantId);

}


