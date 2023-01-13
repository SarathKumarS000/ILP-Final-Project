package com.eminence.chitty.jwt.dto;

import lombok.Data;

@Data
public class ChangePassword {

    private String email;
    private String newPassword;
    private String currentPassword;
}
