package com.rbs.cwe209.config;

import com.rbs.cwe209.repository.UserRepository;
import com.rbs.cwe209.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component

public class DatabaseAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseAuthenticationProvider.class);

    private final UserRepository userRepository;

    private static final String PASSWORD_WRONG_MESSAGE = "Authentication failed for username='%s',password='%s'";

    public DatabaseAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        LOG.info("Logging in as {}/{}", username, password);

        String pass = userRepository.findByUsername(username);
        if(pass==null) {
            throw new BadCredentialsException("The entered username doesn't exist");
        }
        else if(password.equals(pass)){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        }
        else {

          /* console.log("Username: "+username);
           console.log("Entered password: "+password);
           console.log("Password: "+pass);*/
            throw new BadCredentialsException("Wrong password for username "+ username);
        }





    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
