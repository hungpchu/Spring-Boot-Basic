package com.example.hungpchu.SpringSecurityTutorial.SpringSecurityTutorial.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public UserDetailsService userDetailsService()
    {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                // method is not safe just for demo
                User.withDefaultPasswordEncoder()
                        .username("hchu")
                        .password("123")
                        .roles("USER")
                        .build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws  Exception
    {
        httpSecurity.authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/hello").permitAll()
                .and().logout().permitAll();
    }
}
