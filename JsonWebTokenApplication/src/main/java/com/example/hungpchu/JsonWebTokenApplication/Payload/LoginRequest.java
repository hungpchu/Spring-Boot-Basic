package com.example.hungpchu.JsonWebTokenApplication.Payload;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
