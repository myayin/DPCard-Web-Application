package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.Repository.ParkingAreaTransactionHistoryRepository;
import com.example.DBPROJECT.Resource.ParkingAreaTransactionHistoryResource;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.dto.ParkingAreaTransactionHistoryDto;
import com.example.DBPROJECT.dto.RestaurantTransactionHistoryDto;
import com.example.DBPROJECT.services.ParkingAreaTransactionHistoryService;
import com.example.DBPROJECT.services.RestaurantTransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/parking")
public class ParkingAreaTransactionHistoryController {

    @Autowired
    ParkingAreaTransactionHistoryService parkingAreaTransactionHistoryService;

    @PostMapping("/insert-history")
    public ParkingAreaTransactionHistoryResource insertHistory(@RequestBody ParkingAreaTransactionHistoryDto parkingAreaTransactionHistoryDto) {

        return parkingAreaTransactionHistoryService.insertHistory(parkingAreaTransactionHistoryDto);
    }

}
