package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.AuthorityRepository;
import com.example.DBPROJECT.Repository.ConfirmationTokenRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.Repository.RestaurantTransactionHistoryRepository;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.Resource.RestaurantTransactionHistoryResource;
import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.entity.RestaurantTransactionHistory;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import com.example.DBPROJECT.mapper.RestaurantTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private RestaurantTransactionHistoryRepository restaurantTransactionHistoryRepository;

    public EmployeeResource save(Employee employee) {
        Employee existingUser = employeeRepository.findWithMail(employee.getEmployeeEmail());

        if (existingUser != null) {
            throw new RuntimeException("MAIL_ALREADY_EXISTS");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        employee.setEmployeePassword(encoder.encode(employee.getEmployeePassword()));

        employeeRepository.insertEmployee(employee.getEmployeeName(),
                employee.getEmployeeSurname(), employee.getEmployeeEmail(), employee.getEmployeePassword(), employee.getEmployeePhone());
     confirmationTokenService.sendToken(employeeRepository.findIDWithEmail(employee.getEmployeeEmail()), "EMPLOYEE_REGISTER");

        authorityRepository.updateAuthority("User",employee.getEmployeeEmail());
        return EmployeeMapper.toResource(employee);
    }

    public EmployeeResource confirmRegister(String confirmationToken) {

        Employee employee = employeeRepository.findWithID(confirmationTokenRepository.findEmployeeIDWithToken(confirmationToken));
        if (employee == null) {
            throw new RuntimeException("USER_NOT_EXIST");
        }

        confirmationTokenRepository.updateTokenStatus(confirmationToken, "CONFIRMED");
        confirmationTokenRepository.confirmEmployee(confirmationToken);

        return EmployeeMapper.toResource(employee);
    }

    public List<RestaurantTransactionHistoryResource> getRestaurantHistory(String employeeEmail) {
        List<RestaurantTransactionHistoryResource> transactionHistoryResources = new ArrayList<>();


        for (RestaurantTransactionHistory restaurantTransactionHistory : restaurantTransactionHistoryRepository.findTransactionForEmployee(employeeRepository.findIDWithEmail(employeeEmail))) {
            transactionHistoryResources.add(RestaurantTransactionMapper.toResource(restaurantTransactionHistory));
            transactionHistoryResources.get(transactionHistoryResources.size() - 1).setCompanyName(restaurantTransactionHistoryRepository.getCompanyName(restaurantTransactionHistory.getRestaurantTransactionHistoryID()));
            // transactionHistoryResources.get(transactionHistoryResources.size()-1).setCompanyName(contractedMerchantRepository.getCompanyName(contractedMerchantEmail));
        }
        return transactionHistoryResources;
    }
}
