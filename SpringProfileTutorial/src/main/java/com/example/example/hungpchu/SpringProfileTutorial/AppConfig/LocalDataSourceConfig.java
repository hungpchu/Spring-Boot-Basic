package com.example.example.hungpchu.SpringProfileTutorial.AppConfig;

import com.example.example.hungpchu.SpringProfileTutorial.Model.LocalDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("local")
public class LocalDataSourceConfig {

    @Bean
    public LocalDataSource localDataSource()
    {
        return new LocalDataSource();
    }
}
