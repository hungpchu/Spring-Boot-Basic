package com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Model;

import lombok.Data;
import javax.persistence.*;

/***
 * Tạo ra class User tham chiếu với database.
 */
@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
}
