package com.fa.couponsasart.domain.dto;


import com.fa.couponsasart.configurations.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class ClientDTO<ID> extends BasicDTO<ID> {

    @NotNull
    @NotBlank
    @Pattern(regexp = ValidationConstants.Regex.EMAIL)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = ValidationConstants.Client.PASSWORD_MIN_LEN, max = ValidationConstants.Client.PASSWORD_MAX_LEN)
    @Pattern(regexp = ValidationConstants.Regex.PASSWORD)
    private String password;
}
