package com.example.hungpchu.ConfigurePropertyTutorial;

import com.example.hungpchu.ConfigurePropertyTutorial.Model.HungChu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ConfigurePropertyTutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurePropertyTutorialApplication.class, args);
	}

	@Autowired
	HungChu hungChu;

	@Override
	public void run(String...args) throws Exception
	{
		System.out.println("Global Variable: ");
		System.out.println("\t Email: "+hungChu.getEmail());
		System.out.println("\t GA ID: "+hungChu.getGoogle());
		System.out.println("\t Authors: " + hungChu.getAuthors());
		System.out.println("\t Map: " + hungChu.getMap());
	}

}
