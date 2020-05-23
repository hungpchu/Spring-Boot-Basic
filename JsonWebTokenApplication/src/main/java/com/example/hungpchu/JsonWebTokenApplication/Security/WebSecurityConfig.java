package com.example.hungpchu.JsonWebTokenApplication.Security;

import com.example.hungpchu.JsonWebTokenApplication.JsonWebToken.JwtLoginFilter;
import com.example.hungpchu.JsonWebTokenApplication.JsonWebToken.JwtAuthenticationFiler;
import com.example.hungpchu.JsonWebTokenApplication.Repository.UserRepository;
import com.example.hungpchu.JsonWebTokenApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Class này chịu trách nhiệm cho configuration bean và enableWebSecurity
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    /**
     * AuthenticationManagerBuilder to confiure the userService and passwordEncoder
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }


    @Override
    public void configure(WebSecurity web)
    {
        /**
         * ignore so I can view localhost:8080/h2-console online
         */
        web.ignoring()
                .antMatchers("/h2-console/**", "/api/signUp");
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws  Exception
    {
        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers( "/login","/api/signUp").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                .anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập


        /**
         * Taọ mỗi lớp filter khác nhau cho /login và other method
         */
        httpSecurity.addFilterBefore(new JwtLoginFilter("/login", userService, authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(new JwtAuthenticationFiler(userService), UsernamePasswordAuthenticationFilter.class);



    }

}


