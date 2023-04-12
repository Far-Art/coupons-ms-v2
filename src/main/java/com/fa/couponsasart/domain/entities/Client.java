package com.fa.couponsasart.domain.entities;

import com.fa.couponsasart.configurations.JpaConstants;
import com.fa.couponsasart.configurations.ValidationConstants;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Client extends BasicEntity {

    @NotNull
    @NotBlank
    @Pattern(regexp = ValidationConstants.Regex.EMAIL)
    @Column(unique = true, length = JpaConstants.Column.Size.EMAIL_MAX_LEN)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = ValidationConstants.Client.PASSWORD_MIN_LEN, max = ValidationConstants.Client.PASSWORD_MAX_LEN)
    @Pattern(regexp = ValidationConstants.Regex.PASSWORD)
    private String password;

}
