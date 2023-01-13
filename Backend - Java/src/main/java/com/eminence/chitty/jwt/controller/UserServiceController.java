package com.eminence.chitty.jwt.controller;


import com.eminence.chitty.jwt.dto.UserRegistrationDTO;
import com.eminence.chitty.jwt.entity.UserRegistration;
import com.eminence.chitty.jwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserServiceController {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

    @Autowired
    UserService userService;

    @PostMapping({"/user-profile"})
    private UserRegistration registerNewUserAccount(@RequestBody UserRegistrationDTO add) {
        logger.info("User registration");
        return userService.registerNewUserAccount(add);
    }
}
