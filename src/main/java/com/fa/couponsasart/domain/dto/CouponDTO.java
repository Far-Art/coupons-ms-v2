package com.fa.couponsasart.domain.dto;

import com.fa.couponsasart.configurations.ValidationConstants;
import com.fa.couponsasart.domain.behaviours.DeeplyValidatedBean;
import com.fa.couponsasart.domain.exceptions.ValidationException;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CouponDTO extends BasicDTO implements DeeplyValidatedBean {

//    private CompanyDTO owningCompany;

    @NotNull
    @NotBlank
    private String category;

    @NotNull
    @NotBlank
    @Size(min = ValidationConstants.Coupon.TITLE_MIN_LEN, max = ValidationConstants.Coupon.TITLE_MAX_LEN)
    private String title;

    @Size(max = ValidationConstants.Coupon.DESCRIPTION_MAX_LEN)
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startDate;

    @NotNull
    @Future
    private LocalDateTime endDate;

    @PositiveOrZero
    private long amount;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;

    private String imageUrl;

    @Override
    public void validate() throws ValidationException {
        if (startDate.isAfter(endDate)) {
            throw new ValidationException("Start date cannot exceed end date");
        }
    }
}
