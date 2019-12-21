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
            value = "INSERT INTO contracted_merchant (company_name, contracted_merchant_email, contracted_merchant_password, contracted_merchant_status)" +
                    "VALUES (:CName, :CMail, :CPassword ,'1')",
            nativeQuery = true)


    @Transactional
    void insertContractedMerchant(@Param("CName") String companyName,
                        @Param("CMail") String companyEmail,
                        @Param("CPassword") String companyPassword);

}
