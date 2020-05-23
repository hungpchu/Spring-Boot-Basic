package com.example.hungpchu.SwaggerTutorial.Repository;


import com.example.hungpchu.SwaggerTutorial.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
