package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.Resource.ContractedMerchantResource;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.dto.ContractedMerchantDto;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.entity.ContractedMerchant;
import com.example.DBPROJECT.mapper.ContractedMerchantMapper;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.services.ContractedMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contractedMerchant")
public class ContractedMerchantController {
    @Autowired
    ContractedMerchantService contractedMerchantService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ContractedMerchantResource registerContractedMerchantController (@RequestBody ContractedMerchantDto contractedMerchantDto) {

        return contractedMerchantService.save(ContractedMerchantMapper.toEntity(contractedMerchantDto));

    }
}
