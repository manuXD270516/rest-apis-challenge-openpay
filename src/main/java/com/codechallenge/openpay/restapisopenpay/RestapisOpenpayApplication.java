package com.codechallenge.openpay.restapisopenpay;

import com.codechallenge.library.clientapi.domain.ComicApiResponse;
import com.codechallenge.library.clientapi.service.MarvelApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {
        "com.codechallenge.openpay.restapisopenpay"}
)
@ComponentScan(basePackages ={"com.codechallenge.library.clientapi", "com.codechallenge.openpay.restapisopenpay"} )
public class RestapisOpenpayApplication {

    //@Autowired
    //private MarvelApiClientService marvelApiClientService;

    public static void main(String[] args) {
        SpringApplication.run(RestapisOpenpayApplication.class, args);
    }

    /*@Bean
    @ConditionalOnBean(MarvelApiClientService.class)
    public CommandLineRunner commandLineRunner() {
        return args -> {
            ComicApiResponse result = marvelApiClientService.getCharacters();
            System.out.println("Result: " + result.getCopyright());
            System.out.println("dsa");
        };

    }*/
}
