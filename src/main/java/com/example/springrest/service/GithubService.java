package com.example.springrest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class GithubService {


    @Autowired
    private OAuth2RestTemplate restTemplate;

    public String getUserRepos() {
        String apiUrl = "https://api.github.com/user/repos";
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
