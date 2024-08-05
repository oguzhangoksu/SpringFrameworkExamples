package com.haydikodlayalim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.haydikodlayalim.repository")
public class Main {
    
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}