package com.example.springrest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
/*@EnableWebSecurity
@EnableWebFluxSecurity*/
//@EnableWebSecurity
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SpringSecurityConf {

  /*  @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/resources/**", "/signup", "/about").permitAll()
                        .anyRequest().permitAll())
                .build();
    }*/


    @Bean
    SecurityWebFilterChain springSecurityFilterChain(final ServerHttpSecurity http) {

       /* http .csrf(csrf -> csrf.disable());

        return http.build();*/

        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        .anyExchange().permitAll()
                );

        return http.build();
    }




    public NegatedServerWebExchangeMatcher getURLsForDisabledCSRF() {
        return new NegatedServerWebExchangeMatcher(exchange -> ServerWebExchangeMatchers.pathMatchers("/github/repo").matches(exchange));
    }
}
