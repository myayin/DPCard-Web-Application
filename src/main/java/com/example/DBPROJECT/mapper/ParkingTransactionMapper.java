package com.example.DBPROJECT.mapper;

import com.example.DBPROJECT.Resource.ParkingAreaTransactionHistoryResource;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.entity.ParkingAreaTransactionHistory;
import com.example.DBPROJECT.entity.RestaurantTransactionHistory;

public class ParkingTransactionMapper {

    public static ParkingAreaTransactionHistoryResource toResource(ParkingAreaTransactionHistory parkingAreaTransactionHistory) {
        if (parkingAreaTransactionHistory == null) {
            return null;
        }

        ParkingAreaTransactionHistoryResource parkingAreaTransactionHistoryResource = new ParkingAreaTransactionHistoryResource();
        parkingAreaTransactionHistoryResource.setEntryDate(parkingAreaTransactionHistory.getEntryDate());
        parkingAreaTransactionHistoryResource.setExtension(parkingAreaTransactionHistory.getExtension());


        return parkingAreaTransactionHistoryResource;
    }
}
