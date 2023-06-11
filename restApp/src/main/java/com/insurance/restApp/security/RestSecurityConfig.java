package com.insurance.restApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class RestSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.DELETE, "/api/clients").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/clients").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/clients","/api/clients/{clientId}").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/clients").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/api/insurance").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/insurance").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/insurance","/api/insurance/{insuranceId}").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/insurance").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/api/claims").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/claims").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/claims","/api/claims/{claimId}").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/claims").hasRole("EMPLOYEE")
                );
        http.httpBasic(Customizer.withDefaults());
        return  http.build();
    }
}
