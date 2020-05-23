package com.example.hungpchu.JsonWebTokenApplication.Service;

import com.example.hungpchu.JsonWebTokenApplication.Model.CustomerUserDetails;
import com.example.hungpchu.JsonWebTokenApplication.Model.User;
import com.example.hungpchu.JsonWebTokenApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomerUserDetails(user);
    }

    public List<User> loadUserByUsernameAndPassword(String username, String password){
        return userRepository.findUserByUsernameAndPassword(username,password);
    }


}