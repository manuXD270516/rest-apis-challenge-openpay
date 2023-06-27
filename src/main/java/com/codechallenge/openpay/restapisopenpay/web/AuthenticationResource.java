package com.codechallenge.openpay.restapisopenpay.web;

import com.codechallenge.openpay.restapisopenpay.common.enums.auth.AuthenticationRequest;
import com.codechallenge.openpay.restapisopenpay.common.enums.auth.AuthenticationResponse;
import com.codechallenge.openpay.restapisopenpay.service.JwtTokenService;
import com.codechallenge.openpay.restapisopenpay.service.JwtUserDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailService jwtUserDetailsService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody @Valid final AuthenticationRequest authenticationRequest) {
        /*try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getLogin(), authenticationRequest.getPassword()));
        } catch (final BadCredentialsException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }*/
        try {
            final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getLogin());
            jwtUserDetailsService.matchPassword(authenticationRequest.getLogin(), authenticationRequest.getPassword());
            final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setAccessToken(jwtTokenService.generateToken(userDetails));
            return authenticationResponse;
        } catch (UsernameNotFoundException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

}