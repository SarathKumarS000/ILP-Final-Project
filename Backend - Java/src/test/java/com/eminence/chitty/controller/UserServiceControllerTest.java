package com.eminence.chitty.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void submitRegistrationSuccess() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/user-profile")
//                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("firstName", "Sreeni")
                                .param("lastName", "Sreeni")
                                .param("email", "new@logwintech.com")
                                .param("mobileNo", "12345678")
                                .param("passWord", "password")
                                .param("roleId", "2")


                )

                .andExpect(status().isOk())
                .andDo(print());
    }



}