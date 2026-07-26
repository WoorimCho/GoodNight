package com.example.goodnightworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@EnableFeignClients
@SpringBootApplication
public class GoodNightWorldApplication {
    private static final Logger log = LoggerFactory.getLogger(GoodNightWorldApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GoodNightWorldApplication.class, args);
    }

//    @Bean
//    @Profile("!test")
//    public ApplicationRunner run(RestClient.Builder builder) {
//        RestClient restClient = builder.baseUrl("http://localhost:8080").build();
//        return args -> {
//            String response = restClient.get().uri("/night").retrieve().body(String.class);
//            log.info("Response from /night endpoint: {}", response);
//        };
//    }
}

