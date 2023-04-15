package com.fa.couponsasart.services;

import com.fa.couponsasart.domain.dto.CouponDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CouponsService<ID> {

    List<CouponDTO> getAll(Optional<List<String>> category, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice);

    Optional<CouponDTO> getById(ID id);

    CouponDTO addNew(CouponDTO dto);

    boolean deleteById(ID id);

    boolean updateById(ID id, CouponDTO dto);

    boolean patchById(ID id, CouponDTO dto);

}
