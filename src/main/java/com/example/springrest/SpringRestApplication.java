package com.example.springrest;

import com.example.springrest.service.GithubService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class SpringRestApplication {

    public static void main(String[] args) {
     var context =   SpringApplication.run(SpringRestApplication.class, args);
     var git = context.getBean(GithubService.class);
//    String re = git.getUserWeClient();
//        System.out.println(re);
    }

}
