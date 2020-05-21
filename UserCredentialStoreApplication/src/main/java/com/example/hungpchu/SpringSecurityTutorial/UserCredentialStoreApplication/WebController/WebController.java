package com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.WebController;

import com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Model.User;
import com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    UserRepository userRepository;

    // Lay tu bean cua class WebSecureConfig
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value={"/","/home"})
    public String index(){ return "home"; }

    @GetMapping("/hello")
    public String hello(){ return "hello"; }

    @GetMapping("/signUp")
    public String signUp(Model model)
    {
        model.addAttribute("newUser", new User());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String success(@ModelAttribute User user)
    {
        // dùng passwordEncoder để mã hoá password trong csdl
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Insert vào cơ sở dữ liệu một user.
        userRepository.save(user);
        return "success";
    }

}
