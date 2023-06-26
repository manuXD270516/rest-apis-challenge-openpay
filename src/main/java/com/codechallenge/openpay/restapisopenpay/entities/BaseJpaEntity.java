package com.codechallenge.openpay.restapisopenpay.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;
@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({AuditingEntityListener.class, ChangeLogListener.class})
public abstract class BaseJpaEntity {


    @Id
    @Basic(optional = false)
    @Column(unique = true, name = "id", columnDefinition = "uuid", nullable = false)
    private String id;

    @Column(name = "status", nullable = false)
    private Integer status = 1;


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "createdAt", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "lastModifiedAt")
    private Date lastModifiedAt;


}