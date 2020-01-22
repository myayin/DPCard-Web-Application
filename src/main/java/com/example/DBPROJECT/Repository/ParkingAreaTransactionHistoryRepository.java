package com.example.DBPROJECT.Repository;

import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.entity.ParkingAreaTransactionHistory;
import com.example.DBPROJECT.entity.RestaurantTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParkingAreaTransactionHistoryRepository extends JpaRepository<ParkingAreaTransactionHistory, String> {

    @Modifying(clearAutomatically = true)
    @Query(
            value = "INSERT INTO parking_area_transaction_history (employeeid, dpcardid, contracted_merchantid, extension)" +
                    "VALUES (:Eid, :Did, :Cid , :extension)",
            nativeQuery = true)


    @Transactional
    void insertHistory(@Param("Eid") int employeeId,
                       @Param("Did") String dpCardId,
                       @Param("Cid") int contractedMerchantId,
                       @Param("extension") int extension);

    @Query(
            value = "SELECT * FROM parking_area_transaction_history WHERE employeeid = :EID ", nativeQuery = true
    )
    List<ParkingAreaTransactionHistory> findTransactionForEmployee(@Param("EID") int employeeId);

    @Query(
            value = "SELECT company_name FROM parking_area_transaction_history " +
                    "left join contracted_merchant on parking_area_transaction_history.contracted_merchantid= contracted_merchant.contracted_merchantid " +
                    "where parking_area_transaction_history.parking_area_transaction_historyid = :PID", nativeQuery = true
    )
    String  getCompanyName(@Param("PID") String parkingTransactionHistoryOrderId);

    @Query(
            value = "SELECT * FROM parking_area_transaction_history WHERE contracted_merchantid = :CID ", nativeQuery = true
    )
    List<ParkingAreaTransactionHistory> findTransactionWithId(@Param("CID") int contractedMerchantID);
}
