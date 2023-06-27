package com.codechallenge.openpay.restapisopenpay.service;

import com.codechallenge.openpay.restapisopenpay.common.enums.auth.JwtUserDetails;
import com.codechallenge.openpay.restapisopenpay.entities.AuthUser;
import com.codechallenge.openpay.restapisopenpay.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JwtUserDetailService implements UserDetailsService {

    public static final String USER = "USER";
    public static final String ROLE_USER = "ROLE_" + USER;

    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        AuthUser userFind = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
        final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return new JwtUserDetails(userFind.getId(), username, String.valueOf(userFind.hashCode()), roles);
    }

    public boolean matchPassword(final String username, final String password){
        authUserRepository.matchPassword(username, password).orElseThrow(() -> new UsernameNotFoundException("Password not match of " + username ));
        return true;
    }

}
