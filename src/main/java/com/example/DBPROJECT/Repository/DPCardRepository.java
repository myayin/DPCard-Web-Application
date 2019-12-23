package com.example.DBPROJECT.Repository;


import com.example.DBPROJECT.entity.DPCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DPCardRepository extends JpaRepository<DPCard, String> {

    @Query(
            value = "Select dpcardid from dpcard left join employee on dpcard.employeeid=employee.employeeid where employee.employee_email = :email ", nativeQuery = true
    )
   String  findIdWithEmail(@Param("email") String  email);

}
