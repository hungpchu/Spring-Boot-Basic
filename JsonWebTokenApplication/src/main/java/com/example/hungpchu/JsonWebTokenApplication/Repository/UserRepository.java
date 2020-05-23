package com.example.hungpchu.JsonWebTokenApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hungpchu.JsonWebTokenApplication.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    List<User> findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
