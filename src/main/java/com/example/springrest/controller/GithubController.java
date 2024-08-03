package com.example.springrest.controller;

import com.example.springrest.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class GithubController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    
    private final GithubService githubService;
//    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @Autowired
    public GithubController(GithubService githubService/* OAuth2AuthorizedClientService oAuth2AuthorizedClientService*/) {
        this.githubService = githubService;
//        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }


    @GetMapping("/repo")
    public void getRepo(OAuth2AuthenticationToken token) {
        String accessToken = getToken(token, "github");
    }

    private String getToken(OAuth2AuthenticationToken token, String clientRegistration) {
       /* OAuth2AuthorizedClient client = oAuth2AuthorizedClientService
                .loadAuthorizedClient(clientRegistration, token.getName());
        if (client != null) {
            OAuth2AccessToken accessToken = client.getAccessToken();
            if (accessToken != null) {
                return accessToken.getTokenValue();
            }
        }*/
        return null;
    }
}
