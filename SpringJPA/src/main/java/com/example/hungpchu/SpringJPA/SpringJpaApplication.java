package com.example.hungpchu.SpringJPA;

import com.example.hungpchu.SpringJPA.Model.User;
import com.example.hungpchu.SpringJPA.Repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {

		// container of springboot or context
		ApplicationContext context =  SpringApplication.run(SpringJpaApplication.class, args);
		// bean or component in container
		UserRepository userRepository = context.getBean(UserRepository.class);

		/**
		 * spring jpa default method
		 */
		// lấy toàn bộ user trong db
		userRepository.findAll().forEach(System.out::println);

		// lưu user trong db
		User user = userRepository.save(new User());

		System.out.println("new User with ID: " + user.getId());
		Long userId = user.getId();

		// update value of agi for new
		user.setAgi(100);

		// update user trên khi nó vừa update value of Agi
		// update new user chứ k insert cái mới
		userRepository.save(user);

		// tìm user vừa mới
		User searchUser = userRepository.findById(userId).get();
		System.out.println("User: " + user);
		System.out.println("Search User: " + searchUser);

		// delete user vừa luu
		userRepository.delete(user);

		User user3 = userRepository.findById(userId).orElse(null);
		System.out.println("Delete user3: " + user3);


		/***
		 * Spring JPA make up method
		 */

		System.out.println("Tìm user với Agi trong khoảng (25-30)");
		System.out.println("findAllByAgiBetween(25-30):");
		userRepository.findAllByAgiBetween(25,30).forEach(System.out::println);

		System.out.println("===========================================");
		System.out.println("Tìm user với Agi trong lớn hơn 97");
		System.out.println("findAllByAgiGreaterThan: ");
		userRepository.findAllByAgiGreaterThan(97).forEach(System.out::println);

		// Tìm kiếm tất cả theo Atk = 74
		System.out.println("===========================================");
		System.out.println("Tìm user với Atk = 74");
		System.out.println("findAllByAtk: ");
		userRepository.findAllByAtk(74).forEach(System.out::println);

		System.out.println("===========================================");
		System.out.println("Tìm User với def = 49");
		System.out.println("SELECT u FROM User u WHERE u.def = :def");
		userRepository.findUserByDefQuery(49).forEach(System.out::println);
	}

}
