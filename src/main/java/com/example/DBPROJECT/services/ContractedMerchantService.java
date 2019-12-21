package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.ConfirmationTokenRepository;
import com.example.DBPROJECT.Repository.ContractedMerchantRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.Resource.ContractedMerchantResource;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.entity.ContractedMerchant;
import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.mapper.ContractedMerchantMapper;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ContractedMerchantService {
    @Autowired
    private ContractedMerchantRepository contractedMerchantRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    public ContractedMerchantResource save(ContractedMerchant contractedMerchant) {

       // ContractedMerchant existingContractedMerchant = contractedMerchantRepository.findWithMail(contractedMerchant.getContractedMerchantEmail();

      /*  if (existingContractedMerchant!= null) {
            throw new RuntimeException("MAIL_ALREADY_EXISTS");
        }*/

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        contractedMerchant.setContractedMerchantPassword(encoder.encode(contractedMerchant.getContractedMerchantPassword()));

        contractedMerchantRepository.insertContractedMerchant(contractedMerchant.getCompanyName(),
                contractedMerchant.getContractedMerchantEmail(), contractedMerchant.getContractedMerchantPassword());
        //   confirmationTokenService.sendToken(employeeRepository.findIDWithEmail(employee.getEmployeeEmail()), "EMPLOYEE_REGISTER");


        return ContractedMerchantMapper.toResource(contractedMerchant);
    }
}
