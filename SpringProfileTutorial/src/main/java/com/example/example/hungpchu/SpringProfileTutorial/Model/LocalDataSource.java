package com.example.example.hungpchu.SpringProfileTutorial.Model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


@Data
public class LocalDataSource {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;
}
