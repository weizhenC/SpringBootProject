package com.jac.mvc.final_project_dec13.config;

import com.jac.mvc.final_project_dec13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-13
 * Project: final_project_dec13
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    //enable authentication functionality
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(c -> c.disable())
//                .authorizeHttpRequests(registry -> {
//                    registry
//                            .requestMatchers("/").permitAll() // allow all users to visit the homepage
//                            .requestMatchers("/registration").permitAll()
//
//                .anyRequest().authenticated();
//    });
//
//        http
//                .formLogin(formLogin -> {
//                        formLogin.loginPage("/login").permitAll();//allow all users to login page
//        });
//
//        return http.build();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(registry -> {
                    registry
                            .requestMatchers("/")
                            .permitAll() // allow all users to visit the homepage
                            .requestMatchers("/registration")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .formLogin(formLogin -> {
                    formLogin.loginPage("/login").permitAll(); // allow all users to access the login page
                })
                .logout(logout -> logout.permitAll()) // allow all users to log out
                .exceptionHandling(configurer -> {
                    configurer.accessDeniedPage("/access-denied"); // specify the access denied page
                });

        return http.build();
    }


}

