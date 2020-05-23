package com.example.hungpchu.JsonWebTokenApplication.JsonWebToken;


import com.example.hungpchu.JsonWebTokenApplication.Service.TokenAuthenticationService;
import com.example.hungpchu.JsonWebTokenApplication.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/***
 * Using the abstract class named GenericFilterBean provided from:
 */
public class JwtAuthenticationFiler extends GenericFilterBean {

    UserService userService;

    public JwtAuthenticationFiler(UserService userService){ this.userService = userService; }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request, userService);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request,response);
    }
}
