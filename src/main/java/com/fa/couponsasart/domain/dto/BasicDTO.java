package com.fa.couponsasart.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public abstract class BasicDTO<ID> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    private final LocalDateTime created;
    private final LocalDateTime updated;
    private ID id;

}
