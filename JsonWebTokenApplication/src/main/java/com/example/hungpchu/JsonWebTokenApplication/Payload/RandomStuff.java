package com.example.hungpchu.JsonWebTokenApplication.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RandomStuff {
    private String message;
    private String Auth;
}
