package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.ConfirmationTokenRepository;
import com.example.DBPROJECT.Repository.ContractedMerchantRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.entity.ConfirmationToken;
import com.example.DBPROJECT.entity.ContractedMerchant;
import com.example.DBPROJECT.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class ConfirmationTokenService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ContractedMerchantRepository contractedMerchantRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;


    @Autowired
    private JavaMailSender javaMailSender;


    public String sendToken(int userId, String type) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("payekart34@gmail.com");

        if (type.equals("EMPLOYEE_REGISTER")) {
            Employee employee = employeeRepository.findWithID(userId);
            if (employee == null) {
                throw new RuntimeException("USER_NOT_EXIST");
            }

            mailMessage.setTo(employeeRepository.returnEmployeeEmail(userId));

            mailMessage.setSubject("Email Confirmation");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/employee/confirm-register?token="
                     +confirmationTokenRepository.findTokenWithEmail(employeeRepository.returnEmployeeEmail(userId)));
        }
        else{
            ContractedMerchant contractedMerchant = contractedMerchantRepository.getMerchantWithID(userId);
            if (contractedMerchant == null) {
                throw new RuntimeException("USER_NOT_EXIST");
            }
            mailMessage.setTo(contractedMerchantRepository.getEmailWithId(userId));
            mailMessage.setSubject("Email Confirmation");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/contractedMerchant/confirm-register?token="
                    +confirmationTokenRepository.findTokenWithEmailForMercahnt(contractedMerchantRepository.getEmailWithId(userId)));
        }

        try {
            javaMailSender.send(mailMessage);
        } catch (RuntimeException exception) {
            throw new RuntimeException("MAIL_SEND_FAILED");
        }

if(type.equals("EMPLOYEE_REGISTER"))
        return confirmationTokenRepository.findTokenWithEmail(employeeRepository.returnEmployeeEmail(userId));
else
    return
    confirmationTokenRepository.findTokenWithEmail(contractedMerchantRepository.getEmailWithId(userId));
    }

}
