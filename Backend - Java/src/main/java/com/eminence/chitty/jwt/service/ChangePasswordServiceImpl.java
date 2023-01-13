package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ManagerRepo;
import com.eminence.chitty.jwt.dao.UserLoginRepo;
import com.eminence.chitty.jwt.dao.UserRegistrationRepo;
import com.eminence.chitty.jwt.dto.ChangePassword;
import com.eminence.chitty.jwt.entity.Manager;
import com.eminence.chitty.jwt.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ChangePasswordServiceImpl implements ChangePasswordService{
    @Autowired
    private UserLoginRepo userLoginRepo;
    @Autowired
    private UserRegistrationRepo userRegistrationRepo;

    @Autowired
    private ManagerRepo managerRepo;
    @Override
    public ResponseEntity<?> changePassword(ChangePassword changePassword) {
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        String encryptedPassword= bcrypt.encode(changePassword.getNewPassword());
        List<UserLogin> login=userLoginRepo.findAll();

        for(UserLogin userLogin:login){
            if (Objects.equals(userLogin.getEmail(), changePassword.getEmail())&& (bcrypt.matches(changePassword.getCurrentPassword(),userLogin.getPassword()))) {
                userLogin.setPassword(encryptedPassword);
                Manager manager = managerRepo.findById(userLogin.getUserId()).get();
                manager.setPassWordStatus("changed");
                manager.setPassWord(encryptedPassword);
                managerRepo.save(manager);
                userLoginRepo.save(userLogin);
                return new ResponseEntity<>("Password updated succesfully", HttpStatus.CREATED);
            }
        }

        return new ResponseEntity<>("User Not Found", HttpStatus.CREATED);
    }
}
