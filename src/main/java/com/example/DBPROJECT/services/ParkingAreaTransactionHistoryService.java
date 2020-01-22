package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.ContractedMerchantRepository;
import com.example.DBPROJECT.Repository.DPCardRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.Repository.ParkingAreaTransactionHistoryRepository;
import com.example.DBPROJECT.Resource.ParkingAreaTransactionHistoryResource;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.dto.ParkingAreaTransactionHistoryDto;
import com.example.DBPROJECT.dto.RestaurantTransactionHistoryDto;
import com.example.DBPROJECT.entity.DPCard;
import com.example.DBPROJECT.entity.ParkingAreaTransactionHistory;
import com.example.DBPROJECT.entity.RestaurantTransactionHistory;
import com.example.DBPROJECT.mapper.ParkingTransactionMapper;
import com.example.DBPROJECT.mapper.RestaurantTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingAreaTransactionHistoryService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ContractedMerchantRepository contractedMerchantRepository;

    @Autowired
    DPCardRepository dpCardRepository;

    @Autowired
    ParkingAreaTransactionHistoryRepository parkingAreaTransactionHistoryRepository;


    public ParkingAreaTransactionHistoryResource insertHistory(ParkingAreaTransactionHistoryDto parkingAreaTransactionHistoryDto) {
        ParkingAreaTransactionHistory parkingAreaTransactionHistory =new ParkingAreaTransactionHistory();
        parkingAreaTransactionHistory.setEmployeeID(employeeRepository.findIDWithEmail(parkingAreaTransactionHistoryDto.getEmployeeEmail()));
        parkingAreaTransactionHistory.setContractedMerchantID(contractedMerchantRepository.findIDWithEmail(parkingAreaTransactionHistoryDto.getContractedMerchantEmail()));
        parkingAreaTransactionHistory.setDPCardID(dpCardRepository.findIdForParkWithEmail(parkingAreaTransactionHistoryDto.getEmployeeEmail()));
        parkingAreaTransactionHistory.setExtension(parkingAreaTransactionHistoryDto.getExtension());
        parkingAreaTransactionHistoryRepository.insertHistory(parkingAreaTransactionHistory.getEmployeeID(),parkingAreaTransactionHistory.getDPCardID(),
                parkingAreaTransactionHistory.getContractedMerchantID(), parkingAreaTransactionHistory.getExtension());
        return ParkingTransactionMapper.toResource(parkingAreaTransactionHistory);

    }
}
