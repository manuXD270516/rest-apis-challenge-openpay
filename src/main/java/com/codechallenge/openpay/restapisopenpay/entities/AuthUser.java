package com.codechallenge.openpay.restapisopenpay.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "AuthUser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AuthUser extends BaseJpaEntity{

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 500)
    private String password;
}
