package com.codechallenge.openpay.restapisopenpay.entities;


import com.codechallenge.openpay.restapisopenpay.common.enums.PersistenceStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ChangeLogListener {

    private String ip;
    {
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @PrePersist
    public void prePersist(final BaseJpaEntity entity) {
        entity.setId(UUID.randomUUID().toString().toUpperCase());
        entity.setStatus(PersistenceStatusEnum
                .CREATED_OR_UPDATED
                .getValue());

    }

    @PreUpdate
    public void preUpdate(final BaseJpaEntity entity) {
        if (entity.getStatus() != null) {
            entity.setStatus(PersistenceStatusEnum
                    .CREATED_OR_UPDATED
                    .getValue());
        }
    }

    @PostPersist
    public void postPersistChangeLog(final BaseJpaEntity entity) {
    }

    @PostUpdate
    public void postUpdateChangeLog(final BaseJpaEntity entity) {
    }
}