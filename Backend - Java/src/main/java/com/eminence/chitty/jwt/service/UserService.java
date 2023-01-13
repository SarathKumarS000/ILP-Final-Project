package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dto.UserRegistrationDTO;
import com.eminence.chitty.jwt.entity.UserRegistration;
import org.springframework.stereotype.Service;

public interface UserService {

    UserRegistration registerNewUserAccount(UserRegistrationDTO userRegistrationDTO);
}
