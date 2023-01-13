package com.eminence.chitty.repository;
import com.eminence.chitty.jwt.dao.UserRegistrationRepo;
import com.eminence.chitty.jwt.entity.UserRegistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRegistrationRepoTest {

    @Autowired
    private UserRegistrationRepo userRegistrationRepo;

    @BeforeEach
    void setUp() {
        System.out.println("Set Up");
    }

    @Test
    void isUserExistsById() {

        Boolean actual=userRegistrationRepo.isUserExistsById(138L);
        assertThat(actual).isTrue();
    }

    @Test
    void saveUser(){
        UserRegistration user = UserRegistration.builder()
                .email("qwert@gmail.com")
                .firstName("asdfgh")
                .lastName("asdfg")
                .mobileNo(12345678L)
                .passWord("asdfghj")
                .roleId(3)
                .build();

        userRegistrationRepo.save(user);

        List<UserRegistration> userRegistrationList = userRegistrationRepo.findAll();

        assertThat(userRegistrationList).isNotNull();
        assertThat(userRegistrationList.size()).isEqualTo(9);


    }

}