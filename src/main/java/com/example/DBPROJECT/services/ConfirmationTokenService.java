package com.example.DBPROJECT.services;

import com.example.DBPROJECT.Repository.ConfirmationTokenRepository;
import com.example.DBPROJECT.Repository.EmployeeRepository;
import com.example.DBPROJECT.entity.ConfirmationToken;
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
    private ConfirmationTokenRepository confirmationTokenRepository;


    @Autowired
    private JavaMailSender javaMailSender;


    public String sendToken(int employeeID, String type) {
        Employee employee = employeeRepository.findWithID(employeeID);
        if (employee == null) {
            throw new RuntimeException("USER_NOT_EXIST");
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("payekart34@gmail.com");
        mailMessage.setTo(employeeRepository.returnEmployeeEmail(employeeID));

        if (type.equals("EMPLOYEE_REGISTER")) {
            mailMessage.setSubject("Email Confirmation");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/employee/confirm-register?token="
                     +confirmationTokenRepository.findTokenWithEmail(employeeRepository.returnEmployeeEmail(employeeID)));
        }

        try {
            javaMailSender.send(mailMessage);
        } catch (RuntimeException exception) {
            throw new RuntimeException("MAIL_SEND_FAILED");
        }


        return confirmationTokenRepository.findTokenWithEmail(employeeRepository.returnEmployeeEmail(employeeID));
    }

}
