package com.example.DBPROJECT.Repository;


import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.entity.ContractedMerchant;
import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.entity.RestaurantTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestaurantTransactionHistoryRepository extends JpaRepository<RestaurantTransactionHistory, String> {
    @Modifying(clearAutomatically = true)
    @Query(
            value = "INSERT INTO restaurant_transaction_history (employeeid, dpcardid, contracted_merchantid, extension, restaurant_transaction_history_order)" +
                    "VALUES (:Eid, :Did, :Cid , :extension, :Rorder)",
            nativeQuery = true)


    @Transactional
    void insertHistory(@Param("Eid") int employeeId,
                        @Param("Did") String dpCardId,
                        @Param("Cid") int contractedMerchantId,
                        @Param("extension") int extension,
                        @Param("Rorder") String restaurantTransactionOrder);

    @Query(
            value = "SELECT * FROM restaurant_transaction_history WHERE contracted_merchantid = :CID ", nativeQuery = true
    )
    List<RestaurantTransactionHistory> findTransactionWithId(@Param("CID") int contractedMerchantID);

    @Query(
            value = "SELECT * FROM restaurant_transaction_history WHERE employeeid = :EID ", nativeQuery = true
    )
    List<RestaurantTransactionHistory> findTransactionForEmployee(@Param("EID") int employeeId);

    @Query(
            value = "SELECT company_name FROM restaurant_transaction_history " +
                    "left join contracted_merchant on restaurant_transaction_history.contracted_merchantid= contracted_merchant.contracted_merchantid " +
                    "where restaurant_transaction_history.restaurant_transaction_historyid = :TID", nativeQuery = true
    )
    String  getCompanyName(@Param("TID") String restaurantTransactionHistoryOrderId);
}

