package com.wpollock.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration for the Spring 6 search app.
 *
 * @author wpollock
 */

/*
 * For this app, we use an inMemory authentication scheme, in which the username
 * and password are hard-coded. BAD IDEA IN THE REAL WORLD!
 */

@EnableWebSecurity
public class SecurityConfig {
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests( authz -> authz
              .antMatchers("/").hasRole("USER")
              .antMatchers("/admin/**").hasRole("ADMIN")
          )
          .formLogin((formLogin) -> formLogin
              .loginPage("/login")
              .failureUrl("/login")
 
          );
    
      return http.build();
    }
    
    @Bean
    public UserDetailsManager userDetailsService() {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

      UserDetails admin = User.withUsername("admin")
          .password(encoder.encode("admin"))
          .roles("ADMIN")
          .build();
    
      return new InMemoryUserDetailsManager(admin);
    }
}