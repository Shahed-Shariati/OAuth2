package com.example.springrest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GithubService {


    @Autowired
    private OAuth2RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;

    public String getUserRepos() {
        String apiUrl = "https://api.github.com/user/repos";
        System.out.println(webClient);
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
