package com.fa.couponsasart.domain.dto;

import com.fa.couponsasart.domain.entities.Coupon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CompanyDTO extends ClientDTO {

    private String name;

//    private List<Coupon> coupons;
}
