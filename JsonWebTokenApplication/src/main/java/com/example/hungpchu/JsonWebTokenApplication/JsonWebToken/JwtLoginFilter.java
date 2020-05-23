package com.example.hungpchu.JsonWebTokenApplication.JsonWebToken;


import com.example.hungpchu.JsonWebTokenApplication.Model.User;

import com.example.hungpchu.JsonWebTokenApplication.Service.TokenAuthenticationService;
import com.example.hungpchu.JsonWebTokenApplication.Service.UserService;
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


/***
 * this class extends from the abstract class AbstractAuthenticationProcessingFilter.java
 * provided from this link: https://github.com/spring-projects/spring-security/blob/master/web/src/main/java/org/springframework/security/web/authentication/AbstractAuthenticationProcessingFilter.java
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    private UserService userService;

    /***
     * Own created constructor
     * @param url
     * @param userService
     * @param authenticationManager
     */
    public JwtLoginFilter(String url,  UserService userService, AuthenticationManager authenticationManager) {
        super(url);
        setAuthenticationManager(authenticationManager);
        this.userService = userService;
    }

    /***
     * implement abstract method the abstract class AbstractAuthenticationProcessingFilter.java
     *  Used to check with the database if the user is correct or not
     * @param request
     * @param response
     * @return Authentication
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        List<User> list  = userService.loadUserByUsernameAndPassword(request.getParameter("username"),request.getParameter("password"));
        if (list == null && list.size() == 0 ) return null;

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(request.getParameter("username"), request.getParameter("password"), Collections.emptyList())
        );
    }

    /***
     * Used to add the token to the request if the above method is successful
     * @param request
     * @param response
     * @param chain
     * @param authResult
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
    }

}
