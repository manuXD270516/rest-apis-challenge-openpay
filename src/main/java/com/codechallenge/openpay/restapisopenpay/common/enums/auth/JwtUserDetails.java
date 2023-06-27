package com.codechallenge.openpay.restapisopenpay.common.enums.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class JwtUserDetails extends User {

    public final String id;

    public JwtUserDetails(final String id, final String username, final String hash,
                          final Collection<? extends GrantedAuthority> authorities) {
        super(username, hash, authorities);
        this.id = id;
    }

}
