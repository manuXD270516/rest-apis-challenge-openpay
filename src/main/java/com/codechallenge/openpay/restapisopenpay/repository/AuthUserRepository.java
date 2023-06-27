package com.codechallenge.openpay.restapisopenpay.repository;

import com.codechallenge.openpay.restapisopenpay.entities.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {

    @Query("select u " +
            "from AuthUser u " +
            "where lower(u.username)=:username " +
            "and u.status=1 ")
    Optional<AuthUser> findByUsername(@Param("username") String username);

    @Query("select u " +
            "from AuthUser u " +
            "where lower(u.username)=:username " +
            "and lower(u.password)=:password " +
            "and u.status=1 ")
    Optional<AuthUser> matchPassword(
            @Param("username") String username,
            @Param("password") String password);

}
