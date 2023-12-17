package com.rbs.cwe209.config;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationErrorHandler implements AuthenticationFailureHandler  {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage=exception.getMessage();
        request.getSession().setAttribute("message", errorMessage);
        response.sendRedirect("/login");
    }
}
