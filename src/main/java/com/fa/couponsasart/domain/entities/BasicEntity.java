package com.fa.couponsasart.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@SuperBuilder
@MappedSuperclass
public abstract class BasicEntity {

    @CreationTimestamp
    @Column(updatable = false)
    private final LocalDateTime created;

    @UpdateTimestamp
    private final LocalDateTime updated;

    public abstract String getId();

    // TODO generating id as UUID, see https://vladmihalcea.com/uuid-database-primary-key/

    public abstract void setId(String id);

}
