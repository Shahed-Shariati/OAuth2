package com.example.springrest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class oauthconfig {


    @Bean
    public OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

    @Bean
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId("Ov23liUegaLVGQkiQhap");
        details.setClientSecret("d42c9ebb2ef4b972f149b7a0639823ece9ec804a");
        details.setAccessTokenUri("https://example.com/oauth/token");
        details.setGrantType("client_credentials");
        return details;
    }
}
