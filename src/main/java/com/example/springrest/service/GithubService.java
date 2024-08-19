package com.example.springrest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GithubService {


    /*@Autowired
    private OAuth2RestTemplate restTemplate;*/
    @Autowired
    private WebClient webClient;

    public String getUserRepos() {
        String apiUrl = "http://localhost:8081/api/test";
        /*System.out.println(webClient);*/
//        restTemplate.exchange(apiUrl,HttpMethod.GET,String.class);
//        return restTemplate.getForObject(apiUrl, String.class);
        return null;
    }

    public Mono<String> getUserWeClient() {
        return webClient.get().uri("http://localhost:8081/api/test").retrieve().bodyToMono(String.class);
//        http://localhost:8082/swagger-ui/webjars/swagger-ui/index.html
    }
}




