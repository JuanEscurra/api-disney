package com.challenge.apidisney.security.filters;

import com.challenge.apidisney.security.services.AuthenticationService;
import com.challenge.apidisney.utils.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Authentication");
        String token = ((HttpServletRequest)request).getHeader("Authorization");
        if(token != null) {
            try {
                Authentication authentication = AuthenticationService.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                handleError((HttpServletRequest) request, (HttpServletResponse) response, e);
            }
        } else {
            System.out.println("else");
            filterChain.doFilter(request, response);
        }

    }

    public void handleError(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        System.out.println("handleError");
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .title(e.getClass().getSimpleName())
                .detail(e.getMessage())
                .status(401)
                .URI(request.getRequestURI())
                .build();
        response.getWriter().write(mapper.writeValueAsString(errorResponse));
        response.setContentType("application/json");
        response.setStatus(401);
    }
}
