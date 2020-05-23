package com.example.hungpchu.JsonWebTokenApplication.JsonWebToken;


import com.example.hungpchu.JsonWebTokenApplication.Model.User;

import com.example.hungpchu.JsonWebTokenApplication.Service.TokenAuthenticationService;
import com.example.hungpchu.JsonWebTokenApplication.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    private UserService userService;

    public JwtLoginFilter(String url,  UserService userService, AuthenticationManager authenticationManager) {
        super(url);
        setAuthenticationManager(authenticationManager);
        this.userService = userService;
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        List<User> list  = userService.loadUserByUsernameAndPassword(request.getParameter("username"),request.getParameter("password"));
        if (list == null && list.size() == 0 ) throw new IOException("user not here");
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(request.getParameter("username"), request.getParameter("password"), Collections.emptyList())
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
    }

}
