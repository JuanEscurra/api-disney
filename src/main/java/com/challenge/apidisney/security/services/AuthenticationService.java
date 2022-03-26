package com.challenge.apidisney.security.services;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.persistence.EntityNotFoundException;
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

    public static Authentication getAuthentication(String token) throws JwtException {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SIGN_IN_KEY)
                    .parseClaimsJws(token.replace(PREFIX, "")).getBody();
            return new UsernamePasswordAuthenticationToken(
                    claims.getSubject(),
                    null,
                    AuthorityUtils.createAuthorityList("usuario"));
        } catch (ExpiredJwtException e){
            throw new JwtException("El JWT enviado ha expirado.");
        } catch (MalformedJwtException e) {
            throw new MalformedJwtException("El JWT no cumple con el formado correspondiente.");
        } catch (JwtException e) {
            throw new JwtException("Error al intentar manipular JWT");
        }
    }

}
