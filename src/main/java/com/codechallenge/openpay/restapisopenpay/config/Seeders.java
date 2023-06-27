package com.codechallenge.openpay.restapisopenpay.config;

import com.codechallenge.openpay.restapisopenpay.entities.AuthUser;
import com.codechallenge.openpay.restapisopenpay.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeders {

    private final AuthUserRepository authUserRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsers();
    }

    public void seedUsers() {
        List<AuthUser> users = Arrays.asList(
                AuthUser.builder()
                        .username("msaavedra@ensitech.com")
                        .password("123456")
                        .build(),
                AuthUser.builder()
                        .username("manuel.saavedra@gmail.com")
                        .password("111111")
                        .build()
        );
        authUserRepository.saveAll(users);
    }
}
