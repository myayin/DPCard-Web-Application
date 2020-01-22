package com.example.DBPROJECT.Repository;


import com.example.DBPROJECT.entity.DPCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DPCardRepository extends JpaRepository<DPCard, String> {

    @Query(
            value = "Select a.dpcardid From (Select dpcardid from dpcard left join employee " +
                    "on dpcard.employeeid=employee.employeeid " +
                    "where employee.employee_email = :email) " +
                    "as a left join restaurant_card on a.dpcardid=restaurant_card.restaurant_cardid  " +
                    "where a.dpcardid=restaurant_card.restaurant_cardid", nativeQuery = true
    )
   String  findIdForRestWithEmail(@Param("email") String  email);


    @Query(
            value = "Select a.dpcardid From (Select dpcardid from dpcard left join employee " +
                    "on dpcard.employeeid=employee.employeeid " +
                    "where employee.employee_email = :email) " +
                    "as a left join parking_card on a.dpcardid=parking_card.parking_cardid  " +
                    "where a.dpcardid=parking_card.parking_cardid", nativeQuery = true
    )
    String  findIdForParkWithEmail(@Param("email") String  email);

    @Query(
            value = "Select restaurant_card.balance From (Select dpcardid from dpcard left join employee " +
                    "on dpcard.employeeid=employee.employeeid " +
                    "where employee.employee_email = :email) " +
                    "as a left join restaurant_card on a.dpcardid=restaurant_card.restaurant_cardid  " +
                    "where a.dpcardid=restaurant_card.restaurant_cardid", nativeQuery = true
    )
    int  getBalance(@Param("email") String  email);

    @Query(
            value = "Select parking_card.balance From (Select dpcardid from dpcard left join employee " +
                    "on dpcard.employeeid=employee.employeeid " +
                    "where employee.employee_email = :email) " +
                    "as a left join parking_card on a.dpcardid=parking_card.parking_cardid  " +
                    "where a.dpcardid=parking_card.parking_cardid", nativeQuery = true
    )
    int  getBalanceParkingCard(@Param("email") String  email);
}
