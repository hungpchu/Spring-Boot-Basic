package com.example.hungpchu.JsonWebTokenApplication.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

import static java.util.Collections.emptyList;

/**
 * class response for the token builder and retrieve
 */
public class TokenAuthenticationService {

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    static String auth;

    static HashSet<String> userCheck;

    public static String getAuth(){ return auth; }

    /**
     * method use for building the token to return to the user in the path "/login"
     * @param res
     * @param username
     * @throws IOException
     */
    public static void addAuthentication(HttpServletResponse res, String username) throws IOException{
        // set the string jwt of token to be the subject of username
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        res.getWriter().write(TOKEN_PREFIX + " " + JWT);
        auth = TOKEN_PREFIX + " " + JWT;
    }

    /**
     * getAuthentication return the object Authentication for the filter of the
     * other path
     * @param request
     * @return
     */
    public static Authentication getAuthentication(HttpServletRequest request, UserService userService) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token to converse back to the value of username
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            // check if the user in the database then if the user is not null then it is not right
            try{
                if (userService.loadUserByUsername(user) != null ) return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            }catch (UsernameNotFoundException e)
            {
                return null;
            }

        }
        return null;
    }
}
