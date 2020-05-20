package com.example.hungpchu.ConfigurePropertyTutorial.Model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Data
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "hung")
public class HungChu {
    private String email;
    private String google;

    private List<String> authors;

    private HashMap<String,String> map;

}
