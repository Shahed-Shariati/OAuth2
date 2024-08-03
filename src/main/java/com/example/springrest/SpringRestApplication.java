package com.example.springrest;

import com.example.springrest.service.GithubService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
     var context =   SpringApplication.run(SpringRestApplication.class, args);
     var git = context.getBean(GithubService.class);
     git.getUserRepos();
    }

}
