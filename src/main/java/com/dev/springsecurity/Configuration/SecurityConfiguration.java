package com.dev.springsecurity.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
/*
           ┌────────────┐
Request →  │ FilterChain│  → Security checks
           └─────┬──────┘
                 ↓
         ┌───────────────┐
         │ Authorization  │ → Based on role (hasAuthority)
         └─────┬─────────┘
               ↓
         ┌──────────────┐
         │ Authentication│ → Checks username/password via formLogin
         └─────┬────────┘
               ↓
         ┌──────────────┐
         │ PasswordEncoder│ → BCrypt matches password
         └──────────────┘

 */


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
  
  @Bean
  public PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  }
//   @Bean
// public UserDetailsManager userDetailsManager(DataSource dataSource)
// {
//   JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource); 
//   //defining query to retrive user by username 
// jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

//   //defining query to retrive the autorities (role) by username
// jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

//   return jdbcUserDetailsManager;
// }
  

  

 @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/registration", "/register", "/show_login_page", "/plain_login", "/css/**", "/js/**").permitAll()
            .requestMatchers("/user/**").hasAuthority("ROLE_MANAGER")
            .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(form ->
            form
                .loginPage("/show_login_page")//default first page when opening web
                .loginProcessingUrl("/authenticated_user")
                //Spring checks username & password when this URL is hit (from form action)
                .defaultSuccessUrl("/home", true) //After successful login, redirect always to /home
                .permitAll()
        )
        .logout(logout -> logout.permitAll())
        .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

    return http.build();
}

  
}
