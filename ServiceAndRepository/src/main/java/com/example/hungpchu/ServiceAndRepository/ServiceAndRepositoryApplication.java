package com.example.hungpchu.ServiceAndRepository;

import com.example.hungpchu.ServiceAndRepository.Model.Customer;
import com.example.hungpchu.ServiceAndRepository.Service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServiceAndRepositoryApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(ServiceAndRepositoryApplication.class, args);

		CustomerService customerService = context.getBean(CustomerService.class);

		Customer customer = customerService.getRandomCustomerByName();

		System.out.println("Name of the customer is " + customer.getName());
	}

}
