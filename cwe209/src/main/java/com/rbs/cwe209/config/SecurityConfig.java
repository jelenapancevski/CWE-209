
package com.rbs.cwe209.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/logs").hasRole("ADMIN")
                        .requestMatchers("/","/home","/products","/product/{id}","/addtobasket","/sendOrder","/basket",
                                "/searchForm","/searchResults","/promocode").hasRole("USER")
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

