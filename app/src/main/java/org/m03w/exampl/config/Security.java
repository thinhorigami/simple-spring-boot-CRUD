package org.m03w.exampl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public PasswordEncoder pwdEncode() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager RegUser(PasswordEncoder pwdEncode) {
        return new InMemoryUserDetailsManager(List.of(
                User.withUsername("user")
                        .password(pwdEncode.encode("@Apassword123"))
                        .build()
        ));
    }

    @Bean
    public SecurityFilterChain auth(HttpSecurity http) throws Exception {
        return http
            .httpBasic(Customizer.withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(req -> {
                req.requestMatchers("/api/v1/**").authenticated();
            })
            .build();
    }
}
