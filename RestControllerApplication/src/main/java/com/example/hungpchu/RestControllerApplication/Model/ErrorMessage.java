package com.example.hungpchu.RestControllerApplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int status;
    public String message;
}
