package com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Service;

import com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Model.CustomerUserDetails;
import com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Model.User;
import com.example.hungpchu.SpringSecurityTutorial.UserCredentialStoreApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Khi người dùng đăng nhập thì Spring Security sẽ cần
 * lấy các thông tin UserDetails hiện có để kiểm tra.
 * Vì vậy, bạn cần tạo ra một class kế thừa lớp UserDetailsService
 * mà Spring Security cung cấp để làm nhiệm vụ này.
 *
 * http://localhost:8080/login page using this method to check for credential
 * -> relate to userRepository.findUserByUsername(username); to find user name
 *
 * Over all,
 * User supports CustomerUserDetails which support this class
 */
@Service
public class UserService implements UserDetailsService {
    // this below thing is to deal with database finding
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to check input text of username and password of user is in
     * database or not
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        // CustomerUserDetails implement from User
        return new CustomerUserDetails(user);
    }
}
