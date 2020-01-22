package com.example.DBPROJECT.Resource;


import lombok.Getter;
import lombok.Setter;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Getter
@Setter
@Resource
public class ParkingAreaTransactionHistoryResource {
    private  String companyName;

    private Timestamp entryDate;

    private int extension;



}
