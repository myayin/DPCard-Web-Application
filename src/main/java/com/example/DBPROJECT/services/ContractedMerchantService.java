package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.*;
import com.example.DBPROJECT.Resource.ContractedMerchantResource;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.Resource.ParkingAreaTransactionHistoryResource;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.controller.ContractedMerchantController;
import com.example.DBPROJECT.controller.RestaurantTransactionHistoryController;
import com.example.DBPROJECT.entity.*;
import com.example.DBPROJECT.mapper.ContractedMerchantMapper;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.mapper.ParkingTransactionMapper;
import com.example.DBPROJECT.mapper.RestaurantTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContractedMerchantService {
    @Autowired
    private ContractedMerchantRepository contractedMerchantRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    RestaurantTransactionHistoryRepository restaurantTransactionHistoryRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private  ConfirmationTokenService confirmationTokenService;

    @Autowired
    private ParkingAreaTransactionHistoryRepository parkingAreaTransactionHistoryRepository;




    public ContractedMerchantResource save(ContractedMerchant contractedMerchant, boolean type) {

       ContractedMerchant existingContractedMerchant = contractedMerchantRepository.findMerchantWithEmail(contractedMerchant.getContractedMerchantEmail());

        if (existingContractedMerchant!= null) {
            throw new RuntimeException("MAIL_ALREADY_EXISTS");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        contractedMerchant.setContractedMerchantPassword(encoder.encode(contractedMerchant.getContractedMerchantPassword()));

        contractedMerchantRepository.insertContractedMerchant(contractedMerchant.getCompanyName(),
                contractedMerchant.getContractedMerchantEmail(), contractedMerchant.getContractedMerchantPassword(), type);
         confirmationTokenService.sendToken(contractedMerchantRepository.findIDWithEmail(contractedMerchant.getContractedMerchantEmail()), "MERCHANT_REGISTER");
        authorityRepository.updateAuthorityForMerchant("Merchant",contractedMerchant.getContractedMerchantEmail());

        return ContractedMerchantMapper.toResource(contractedMerchant);
    }

    public List<RestaurantTransactionHistoryResource> getRestaurantHistory(String contractedMerchantEmail){
       List<RestaurantTransactionHistoryResource> transactionHistoryResources = new ArrayList<>() ;


        for (RestaurantTransactionHistory restaurantTransactionHistory:restaurantTransactionHistoryRepository.findTransactionWithId(contractedMerchantRepository.findIDWithEmail(contractedMerchantEmail))){
transactionHistoryResources.add(RestaurantTransactionMapper.toResource(restaurantTransactionHistory));
transactionHistoryResources.get(transactionHistoryResources.size()-1).setCompanyName(contractedMerchantRepository.getCompanyName(contractedMerchantEmail));
        }

       return transactionHistoryResources;

    }
    public List<ParkingAreaTransactionHistoryResource> getParkingHistory(String contractedMerchantEmail){
        List<ParkingAreaTransactionHistoryResource> parkingAreaTransactionHistoryResources = new ArrayList<>() ;


        for (ParkingAreaTransactionHistory parkingAreaTransactionHistory:parkingAreaTransactionHistoryRepository.findTransactionWithId(contractedMerchantRepository.findIDWithEmail(contractedMerchantEmail))){
            parkingAreaTransactionHistoryResources.add(ParkingTransactionMapper.toResource(parkingAreaTransactionHistory));
            parkingAreaTransactionHistoryResources.get(parkingAreaTransactionHistoryResources.size()-1).setCompanyName(contractedMerchantRepository.getCompanyName(contractedMerchantEmail));
        }

        return parkingAreaTransactionHistoryResources;

    }

    public ContractedMerchantResource confirmRegister(String confirmationToken) {

        ContractedMerchant contractedMerchant = contractedMerchantRepository.getMerchantWithID(confirmationTokenRepository.findMerchantIDWithToken(confirmationToken));
        if (contractedMerchant == null) {
            throw new RuntimeException("USER_NOT_EXIST");
        }

        confirmationTokenRepository.updateTokenStatus(confirmationToken, "CONFIRMED");
        confirmationTokenRepository.confirmMerchant(confirmationToken);


        return ContractedMerchantMapper.toResource(contractedMerchant);
    }
}
