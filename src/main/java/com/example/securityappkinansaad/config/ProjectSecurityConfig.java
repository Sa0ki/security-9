package com.example.securityappkinansaad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Eren
 **/
@Configuration
public class ProjectSecurityConfig {
    /*@Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }*/

    /*@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
// Configuration to permit all the requests
        http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }*/
    @Bean
    SecurityFilterChain defaultSecurityFilterChain( HttpSecurity http) throws Exception {
        // the custom security configurations
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
