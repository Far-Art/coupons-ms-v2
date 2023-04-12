package com.fa.couponsasart.domain.mappers;

import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.entities.Coupon;

// TODO i have a problem with lombok and inheritance in mapstruct, try to solve later
//@Mapper
public interface CouponMapper {

    //    @BeanMapping(builder = @Builder(disableBuilder = true))
    Coupon toEntity(CouponDTO dto);

    //    @SubclassMapping(source = Coupon.class, target = CouponDTO.class)
//    @BeanMapping(builder = @Builder(disableBuilder = true))
    CouponDTO toDto(Coupon coupon);
}
