package com.fa.couponsasart.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BasicEntity<ID> {

    @CreationTimestamp
    @Column(updatable = false)
    private final LocalDateTime created;

    @UpdateTimestamp
    private final LocalDateTime updated;

    public abstract ID getId();

    // TODO generating id as UUID, see https://vladmihalcea.com/uuid-database-primary-key/

    public abstract void setId(ID id);

}
