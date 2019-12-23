package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.dto.RestaurantTransactionHistoryDto;
import com.example.DBPROJECT.mapper.RestaurantTransactionMapper;
import com.example.DBPROJECT.services.EmployeeService;
import com.example.DBPROJECT.services.RestaurantTransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restaurantHistory")
public class RestaurantTransactionHistoryController {

    @Autowired
    RestaurantTransactionHistoryService restaurantTransactionHistoryService;



    @PostMapping("/insert-history")
    public RestaurantTransactionHistoryResource insertHistory(@RequestBody RestaurantTransactionHistoryDto restaurantTransactionHistoryDto) {

        return restaurantTransactionHistoryService.insertHistory(restaurantTransactionHistoryDto);
    }
}
