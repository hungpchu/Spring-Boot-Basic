package com.example.hungpchu.ConfigurationAndBean;

import com.example.hungpchu.ConfigurationAndBean.Database.Database;
import com.example.hungpchu.ConfigurationAndBean.Database.MongoDB;
import com.example.hungpchu.ConfigurationAndBean.Database.MySQL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConfigurationAndBeanApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(ConfigurationAndBeanApplication.class, args);

		MongoDB mongoDB  = (MongoDB) context.getBean("mongoDB");

		MySQL mySQL = (MySQL) context.getBean("mySQL");

		System.out.println(mongoDB.toString());

		System.out.println(mySQL.toString());
	}

}
