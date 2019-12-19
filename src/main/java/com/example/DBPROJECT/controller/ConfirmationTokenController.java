package com.example.DBPROJECT.controller;

import com.example.DBPROJECT.services.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/confirmation"})
public class ConfirmationTokenController {
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @GetMapping("/send-token")
    public String sendToken(@RequestParam("employeeID") int  employeeID, @RequestParam("type") String type){
        return confirmationTokenService.sendToken(employeeID, type);
    }
}
