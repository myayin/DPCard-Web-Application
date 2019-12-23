package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.Resource.ContractedMerchantResource;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.dto.ContractedMerchantDto;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.entity.ContractedMerchant;
import com.example.DBPROJECT.mapper.ContractedMerchantMapper;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.services.ContractedMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("/contractedMerchant")
public class ContractedMerchantController {
    @Autowired
    ContractedMerchantService contractedMerchantService;




    @RequestMapping(value="/parking/register",method = RequestMethod.POST)
    public ContractedMerchantResource registerParkingContractedMerchant (@RequestBody ContractedMerchantDto contractedMerchantDto) {

        return contractedMerchantService.save(ContractedMerchantMapper.toEntity(contractedMerchantDto),TRUE);

    }
    @RequestMapping(value="/restaurant/register",method = RequestMethod.POST)
    public ContractedMerchantResource registerRestaurantContractedMerchantController (@RequestBody ContractedMerchantDto contractedMerchantDto) {

        return contractedMerchantService.save(ContractedMerchantMapper.toEntity(contractedMerchantDto),FALSE);

    }

    /*@RequestMapping(value="/get-restaurant-history",method = RequestMethod.GET)
    public void chooseHistory(String contractedMerchantEmail){
        RestaurantTransactionHistoryController.
    }

    @RequestMapping(value="/get-restaurant-history",method = RequestMethod.GET)
    public List<RestaurantTransactionHistoryResource> getRestaurantHistory(@RequestParam String contractedMerchantEmail ){
        return contractedMerchantService.getRestaurantHistory(contractedMerchanttEmail);
    }*/

    @GetMapping("/confirm-register")
    public ContractedMerchantResource confirmRegister(@RequestParam("token") String confirmationToken) {
        return contractedMerchantService.confirmRegister(confirmationToken);
    }

}
