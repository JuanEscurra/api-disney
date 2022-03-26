package com.challenge.apidisney.security.beans;

import com.challenge.apidisney.utils.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityBeans {

    @Bean
    public AuthenticationEntryPoint getAuthenticationEntryPoint() {
        return (request, response, authException) -> {
            System.out.println("entryPoint");
            ObjectMapper mapper = new ObjectMapper();
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .title("Acceso denegado")
                    .detail("No tiene la autorización para acceder a dicho recurso")
                    .status(403)
                    .URI(request.getRequestURI())
                    .build();
            response.getWriter().write(mapper.writeValueAsString(errorResponse));
            response.setContentType("application/json");
            response.setStatus(403);
        };
    }
}
