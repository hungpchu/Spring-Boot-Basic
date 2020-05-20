package com.example.example.hungpchu.SpringProfileTutorial.AppConfig;

import com.example.example.hungpchu.SpringProfileTutorial.Model.LocalDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;

/**
 * Use @Configuration and @Bean is one way to create component in applicaitonContext
 */
@Configuration
/**
 * @Profile("local") -> to specific this class use local profile in application-local.yml
 */
public class LocalDataSourceConfig {

    @Bean
    public LocalDataSource localDataSource()
    {
        return new LocalDataSource();
    }
}
