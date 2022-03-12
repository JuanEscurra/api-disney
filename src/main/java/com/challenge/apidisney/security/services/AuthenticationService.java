package com.challenge.apidisney.security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AuthenticationService {

    static final long EXPIRATION_TIME = 86_400_000;
    static final String SIGN_IN_KEY = "SecretKey";
    static final String PREFIX = "Bearer";

    public static void addToken(HttpServletResponse response, Authentication authentication) throws IOException {
        String jwtToken = Jwts.builder().setSubject(authentication.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SIGN_IN_KEY).compact();

        response.addHeader("Authorization", PREFIX + " " + jwtToken);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("token: " + token);
        if(token != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SIGN_IN_KEY)
                    .parseClaimsJws(token.replace(PREFIX, "")).getBody();
            if(claims != null) {

                return new UsernamePasswordAuthenticationToken(
                        claims.getSubject(),
                        null,
                        AuthorityUtils.createAuthorityList("usuario"));
            }
        }
        return null;
    }

}
