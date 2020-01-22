package com.example.DBPROJECT.mapper;

import com.example.DBPROJECT.Resource.ContractedMerchantResource;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.dto.ContractedMerchantDto;
import com.example.DBPROJECT.dto.EmployeeDto;
import com.example.DBPROJECT.entity.ContractedMerchant;
import com.example.DBPROJECT.entity.Employee;

public class ContractedMerchantMapper {
    public static ContractedMerchantResource toResource(ContractedMerchant contractedMerchant) {
        if (contractedMerchant == null) {
            return null;
        }

        ContractedMerchantResource contractedMerchantResource = new ContractedMerchantResource();
        contractedMerchantResource.setContractedMerchantEmail(contractedMerchant.getContractedMerchantEmail());

        return contractedMerchantResource;
    }
    public static ContractedMerchant toEntity(ContractedMerchantDto contractedMerchantDto) {
        if (contractedMerchantDto == null) {
            return null;
        }

        ContractedMerchant contractedMerchant = new ContractedMerchant();
        contractedMerchant.setCompanyName(contractedMerchantDto.getCompanyName());
        contractedMerchant.setContractedMerchantPassword(contractedMerchantDto.getContractedMerchantPassword());
        contractedMerchant.setContractedMerchantEmail(contractedMerchantDto.getContractedMerchantEmail());


        return contractedMerchant;
    }
}
