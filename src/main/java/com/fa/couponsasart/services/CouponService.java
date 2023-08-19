package com.fa.couponsasart.services;

import com.fa.couponsasart.domain.dto.CouponDTO;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface CouponService {

    Page<CouponDTO> getAll(Optional<List<String>> category, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice, Optional<Integer> pageNumber, Optional<Integer> pageSize);

    Optional<CouponDTO> getById(BigInteger id);

    CouponDTO addNew(CouponDTO dto);

    void deleteById(BigInteger id, BigInteger... moreIds);

    void updateById(BigInteger id, CouponDTO dto);

    void patchById(BigInteger id, CouponDTO dto);

}
