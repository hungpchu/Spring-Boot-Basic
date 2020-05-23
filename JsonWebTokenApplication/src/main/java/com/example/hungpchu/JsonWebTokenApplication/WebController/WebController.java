package com.example.hungpchu.JsonWebTokenApplication.WebController;

import com.example.hungpchu.JsonWebTokenApplication.Model.User;
import com.example.hungpchu.JsonWebTokenApplication.Payload.LoginRequest;
import com.example.hungpchu.JsonWebTokenApplication.Payload.RandomStuff;
import com.example.hungpchu.JsonWebTokenApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebController {

    /**
     * post /login method by the Spring security
     */

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signUp")
    public User signUp(@RequestBody LoginRequest loginRequest)
    {
            User user = new User();
            user.setUsername(loginRequest.getUsername());
            user.setPassword(passwordEncoder.encode(loginRequest.getPassword()));
            userRepository.save(user);
            return user;
    }

    @GetMapping("/random")
    public RandomStuff randomStuff()
    {
        System.out.println("random boo");
        return new RandomStuff("Good Job Boy with valid JWT");
    }
}




