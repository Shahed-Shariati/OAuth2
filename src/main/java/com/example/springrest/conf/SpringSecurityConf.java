package com.example.springrest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
@EnableWebFluxSecurity
public class SpringSecurityConf {


    @Bean
    SecurityWebFilterChain springSecurityFilterChain(final ServerHttpSecurity httpSecurity) {
        return httpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .authorizeExchange(authorizeExchangeSpec ->
                                authorizeExchangeSpec
                                        .pathMatchers( "/api/**").permitAll()
                                        .pathMatchers( "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html","/swagger-ui/webjars/swagger-ui/index.html").permitAll()
//                                .pathMatchers( "/swagger-ui.html").permitAll()
//                                        .pathMatchers(HttpMethod.GET, "/api/**").permitAll()
                                        .pathMatchers(
                                                "/favicon.ico",
                                                "/v3/api-docs/**",
                                                "/webjars/**").permitAll()
                                        .anyExchange().authenticated()

                )
                .build();

    }




    public NegatedServerWebExchangeMatcher getURLsForDisabledCSRF() {
        return new NegatedServerWebExchangeMatcher(exchange -> ServerWebExchangeMatchers.pathMatchers("/github/repo").matches(exchange));
    }
}
