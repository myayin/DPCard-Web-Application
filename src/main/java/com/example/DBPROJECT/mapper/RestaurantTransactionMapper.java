package com.example.DBPROJECT.mapper;

import com.example.DBPROJECT.Repository.ContractedMerchantRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.dto.RestaurantTransactionHistoryDto;
import com.example.DBPROJECT.entity.RestaurantTransactionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class RestaurantTransactionMapper {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ContractedMerchantRepository contractedMerchantRepository;


    public   static RestaurantTransactionHistory toEntity(RestaurantTransactionHistoryDto restaurantTransactionHistoryDto) {


        if (restaurantTransactionHistoryDto == null) {
            return null;
        }

        RestaurantTransactionHistory restaurantTransactionHistory = new RestaurantTransactionHistory();
        restaurantTransactionHistory.setExtension(restaurantTransactionHistoryDto.getExtension());
        restaurantTransactionHistory.setRestaurantTransactionHistoryOrder(restaurantTransactionHistory.getRestaurantTransactionHistoryOrder());

        return restaurantTransactionHistory;
    }

    public static RestaurantTransactionHistoryResource toResource(RestaurantTransactionHistory restaurantTransactionHistory) {
        if (restaurantTransactionHistory == null) {
            return null;
        }

        RestaurantTransactionHistoryResource restaurantTransactionResource = new RestaurantTransactionHistoryResource();
        restaurantTransactionResource.setRestaurantTransactionDate(restaurantTransactionHistory.getRestaurantTransactionHistoryDate());
       restaurantTransactionResource.setExtension(restaurantTransactionHistory.getExtension());
       restaurantTransactionResource.setRestaurantTransactionOrder(restaurantTransactionHistory.getRestaurantTransactionHistoryOrder());
        return restaurantTransactionResource;
    }

}
