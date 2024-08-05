package com.example.springrest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*@Configuration
@EnableWebSecurity
@EnableWebFluxSecurity*/
public class SpringSecurityConf {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/resources/**", "/signup", "/about").permitAll()
                        .anyRequest().permitAll())
                .build();
    }
}
