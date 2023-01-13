package com.eminence.chitty.jwt.service;


import com.eminence.chitty.jwt.dto.ChangePassword;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface ChangePasswordService {
    ResponseEntity<?> changePassword(ChangePassword changePassword);
}
