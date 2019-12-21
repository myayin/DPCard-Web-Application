package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.ConfirmationTokenRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.Resource.EmployeeResource;
import com.example.DBPROJECT.entity.Employee;
import com.example.DBPROJECT.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

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


        return EmployeeMapper.toResource(employee);
    }

    public EmployeeResource confirmRegister(String confirmationToken) {

        Employee employee = employeeRepository.findWithID(confirmationTokenRepository.findEmployeeIDWithToken(confirmationToken));
        if (employee == null) {
            throw new RuntimeException("USER_NOT_EXIST");
        }

        confirmationTokenRepository.updateTokenStatus(confirmationToken, "CONFIRMED");

        return EmployeeMapper.toResource(employee);
    }

  /*  public EmployeeResource addVehicle(String numberPlate, String employeeEmail){

    }*/
}
