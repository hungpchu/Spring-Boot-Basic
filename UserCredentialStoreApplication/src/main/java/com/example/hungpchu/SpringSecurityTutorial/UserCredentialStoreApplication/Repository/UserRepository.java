package com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Repository;

import com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Tạo UserRepository kế thừa JpaRepository để truy xuất thông tin từ database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
