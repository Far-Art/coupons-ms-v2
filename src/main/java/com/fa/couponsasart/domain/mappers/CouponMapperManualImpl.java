package com.fa.couponsasart.domain.mappers;

import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.entities.Coupon;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CouponMapperManualImpl implements CouponMapper {
    @Override
    public Coupon toEntity(CouponDTO dto) {
        if (dto == null) {
            return null;
        }

        return Coupon.builder()
                .id(dto.getId())
                .category(dto.getCategory())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .amount(dto.getAmount())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .created(dto.getCreated())
                .updated(dto.getUpdated())
                .build();
    }

    @Override
    public CouponDTO toDto(Coupon coupon) {
        if (coupon == null) {
            return null;
        }

        return CouponDTO.builder()
                .id(coupon.getId())
                .category(coupon.getCategory())
                .title(coupon.getTitle())
                .description(coupon.getDescription())
                .startDate(coupon.getStartDate())
                .endDate(coupon.getEndDate())
                .amount(coupon.getAmount())
                .price(coupon.getPrice())
                .imageUrl(coupon.getImageUrl())
                .created(coupon.getCreated())
                .updated(coupon.getUpdated())
                .build();
    }
}
