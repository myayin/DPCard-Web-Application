package com.example.DBPROJECT.Resource;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Resource
public class RestaurantTransactionHistoryResource {

    private  String companyName;

    private Timestamp restaurantTransactionDate;

    private int extension;

    private String   restaurantTransactionOrder;





}
