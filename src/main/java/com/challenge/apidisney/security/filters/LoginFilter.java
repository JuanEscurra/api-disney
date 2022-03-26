package com.challenge.apidisney.security.filters;

import com.challenge.apidisney.dto.UserDTO;
import com.challenge.apidisney.security.services.AuthenticationService;
import com.challenge.apidisney.utils.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    public LoginFilter(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/auth/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        System.out.println("loginFilter");
        ObjectMapper mapper = new ObjectMapper();
        try {
            UserDTO user = mapper.readValue(request.getInputStream(), UserDTO.class);
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
            return getAuthenticationManager().authenticate(authToken);
        } catch (BadCredentialsException | IOException e) {
            throw new BadCredentialsException("No se han ingresado credenciales validas");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        AuthenticationService.addToken(response, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException {
        SecurityContextHolder.clearContext();
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .title("Credenciales invalidas")
                .status(401)
                .URI(request.getRequestURI())
                .detail("Las credenciales ingresadas no corresponde a ningún usuario registrado")
                .build();
        response.getWriter().write(mapper.writeValueAsString(errorResponse));
        response.setContentType("application/json");
        response.setStatus(401);
    }
}
