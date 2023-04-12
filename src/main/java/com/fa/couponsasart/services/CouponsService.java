package com.fa.couponsasart.services;

import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.entities.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponsService {

    List<CouponDTO> getAll();

    Optional<CouponDTO> getById(String id);

    CouponDTO addNew(CouponDTO dto);

    boolean deleteById(String id);

    boolean updateById(String id, CouponDTO dto);

    boolean patchById(String id, CouponDTO dto);

}
