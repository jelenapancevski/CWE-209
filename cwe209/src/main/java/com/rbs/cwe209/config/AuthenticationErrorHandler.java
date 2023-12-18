package com.rbs.cwe209.config;
import com.rbs.cwe209.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationErrorHandler implements AuthenticationFailureHandler  {
    @Autowired
    UserRepository userRepository;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage=exception.getMessage();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String correctPassword = userRepository.findByUsername(username);

        request.getSession().setAttribute("message", errorMessage);
        if(errorMessage.equals("Wrong password for username "+username)){
            // show debug message
            String debugMessage = "\nUsername: "+username+"\nEntered password: " + password+"\nActual password: "+correctPassword;
            request.getSession().setAttribute("debugMessage", debugMessage);
        }
        response.sendRedirect("/login");
    }
}
