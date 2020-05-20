package com.example.example.hungpchu.SpringProfileTutorial.Model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;

/**
 * Use @Component is another way to create component or bean in the applicationContext
 * -> Use @Value{value} to init the value of the property in the class
 *
 * @Autowired used only when the object is having bean or component in the
 * application context
 *
 * In this application, I will use the 2nd Step with @Configuration and @Bean
 */


@Data
//@Component
public class LocalDataSource {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;
}
