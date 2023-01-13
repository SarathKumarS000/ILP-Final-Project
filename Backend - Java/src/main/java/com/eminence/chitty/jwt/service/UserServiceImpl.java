package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.UserRegistrationRepo;
//import com.experion.mainbackend.dto.UserRegistrationDTO;
//import com.experion.mainbackend.entity.UserRegistration;
//import com.experion.mainbackend.repository.UserRegistrationRepo;
import com.eminence.chitty.jwt.dto.UserRegistrationDTO;
import com.eminence.chitty.jwt.entity.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRegistrationRepo userRegistrationRepo;

    @Override
    public UserRegistration registerNewUserAccount(UserRegistrationDTO userRegistrationDTO)  {
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();

        UserRegistration user = new UserRegistration();
        user.setFirstName(userRegistrationDTO.getFirstName());
        user.setLastName(userRegistrationDTO.getLastName());


        user.setPassWord(bcrypt.encode(userRegistrationDTO.getPassWord()));

        user.setEmail(userRegistrationDTO.getEmail());
        user.setMobileNo(userRegistrationDTO.getMobileNo());
        user.setRoleId(3);
        return userRegistrationRepo.save(user);
    }
}
