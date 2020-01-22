package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.ContractedMerchantRepository;
import com.example.DBPROJECT.Repository.DPCardRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.Repository.RestaurantTransactionHistoryRepository;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.dto.RestaurantTransactionHistoryDto;
import com.example.DBPROJECT.entity.DPCard;
import com.example.DBPROJECT.entity.RestaurantTransactionHistory;
import com.example.DBPROJECT.mapper.RestaurantTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestaurantTransactionHistoryService {
    @Autowired
    RestaurantTransactionHistoryRepository restaurantTransactionHistoryRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ContractedMerchantRepository contractedMerchantRepository;
    @Autowired
    DPCardRepository dpCardRepository;



    public RestaurantTransactionHistoryResource insertHistory(RestaurantTransactionHistoryDto restaurantTransactionHistoryDto) {
     RestaurantTransactionHistory restaurantTransactionHistory =new RestaurantTransactionHistory();
     restaurantTransactionHistory.setEmployeeID(employeeRepository.findIDWithEmail(restaurantTransactionHistoryDto.getEmployeeEmail()));
     restaurantTransactionHistory.setContractedMerchantID(contractedMerchantRepository.findIDWithEmail(restaurantTransactionHistoryDto.getContractedMerchantEmail()));
restaurantTransactionHistory.setDPCardID(dpCardRepository.findIdForRestWithEmail(restaurantTransactionHistoryDto.getEmployeeEmail()));

restaurantTransactionHistory.setExtension(restaurantTransactionHistoryDto.getExtension());
        restaurantTransactionHistoryRepository.insertHistory(restaurantTransactionHistory.getEmployeeID(),restaurantTransactionHistory.getDPCardID(),
                restaurantTransactionHistory.getContractedMerchantID(), restaurantTransactionHistory.getExtension(),
                restaurantTransactionHistoryDto.getRestaurantTransactionHistoryOrder());
        return RestaurantTransactionMapper.toResource(restaurantTransactionHistory);

    }
}
