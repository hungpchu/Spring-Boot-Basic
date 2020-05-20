package com.example.example.hungpchu.SpringProfileTutorial;

import com.example.example.hungpchu.SpringProfileTutorial.Model.LocalDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringProfileTutorialApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringProfileTutorialApplication.class);

		ApplicationContext context = application.run(args);

		LocalDataSource localDataSource = context.getBean(LocalDataSource.class);
		System.out.println(localDataSource);

	}

}
