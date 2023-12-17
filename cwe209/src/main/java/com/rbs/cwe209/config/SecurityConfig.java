/* package com.rbs.cwe209.config;

import com.rbs.cwe209.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService userService() {
        return userService;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests( auth-> auth .requestMatchers("/login", "/home").permitAll()
                        .anyRequest().authenticated()
                        .formLogin( formlogin->formlogin .loginPage("/login").permitAll())


                        http
                                .authorizeRequests()
                                .antMatchers("/", "/home").permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .formLogin()
                                .loginPage("/login")
                                .permitAll()
                                .and()
                                .logout()
                                .permitAll();


    }
}*/

package com.rbs.cwe209.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/home").hasRole("USER")
                        .requestMatchers("/resources/**").permitAll().anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                                .failureHandler(AuthenticationFailureHandler())
                        .loginProcessingUrl("/login")
                        .permitAll()
                        .defaultSuccessUrl("/home")

                        )

                .logout((logout) -> logout.permitAll());


        return http.build();
    }
    @Bean
    public AuthenticationErrorHandler AuthenticationFailureHandler() {
        return new AuthenticationErrorHandler();
    }

}
/*

 http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

* */
