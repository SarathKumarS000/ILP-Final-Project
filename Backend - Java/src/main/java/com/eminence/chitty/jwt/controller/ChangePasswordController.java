package com.eminence.chitty.jwt.controller;

import com.eminence.chitty.jwt.dto.ChangePassword;
import com.eminence.chitty.jwt.service.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class ChangePasswordController {

    @Autowired
    ChangePasswordService changePasswordService;

    @PostMapping("/user/change-password")
    private ResponseEntity<?> changePassword(@RequestBody ChangePassword changePassword) {
        return changePasswordService.changePassword(changePassword);
    }
}
