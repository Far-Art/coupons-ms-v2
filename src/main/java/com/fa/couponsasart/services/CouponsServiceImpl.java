package com.fa.couponsasart.services;

import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.entities.Coupon;
import com.fa.couponsasart.domain.mappers.CouponMapper;
import com.fa.couponsasart.repositories.CouponsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class CouponsServiceImpl implements CouponsService<BigInteger> {

    private final CouponsRepository<BigInteger> couponsRepo;
    private final CouponMapper mapper;

    @Override
    public List<CouponDTO> getAll(Optional<List<String>> category, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice) {
        if (category.isEmpty() && minPrice.isEmpty() && maxPrice.isEmpty()) {
            return findAll();
        }
        return findAllWithParams(category, minPrice, maxPrice);
    }

    @Override
    public Optional<CouponDTO> getById(BigInteger id) {
        // TODO use Hibernate Criteria API, see https://www.baeldung.com/hibernate-initialize-proxy-exception
        // TODO or use NamedEntityGraph, see https://www.baeldung.com/hibernate-common-performance-problems-in-logs
        return Optional.ofNullable(mapper.toDto(findById(id)));
    }

    @Override
    public CouponDTO addNew(CouponDTO dto) {
        Coupon coupon = couponsRepo.save(mapper.toEntity(dto));
        return mapper.toDto(coupon);
    }

    @Override
    public boolean deleteById(BigInteger id) {
        couponsRepo.deleteById(id);
        return !couponsRepo.existsById(id);
    }

    @Override
    public boolean updateById(BigInteger id, CouponDTO dto) {
        if (!couponsRepo.existsById(id)) {
            return false;
        }

        Coupon toBeSaved = mapper.toEntity(dto);
        toBeSaved.setId(id);
        couponsRepo.save(toBeSaved);
        return true;
    }

    @Override
    public boolean patchById(BigInteger id, CouponDTO dto) {
        Coupon found = findById(id);
        if (found == null) {
            return false;
        }


        // TODO implement patch
        return true;
    }

    private Coupon findById(BigInteger id) {
        return couponsRepo.findById(id).orElse(null);
    }

    private List<CouponDTO> findAll() {
        return mapList(couponsRepo.findAll());
    }

    private List<CouponDTO> findAllWithParams(Optional<List<String>> category, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice) {
        // TODO implement
        return null;
    }

    private List<CouponDTO> mapList(List<Coupon> coupons) {
        if (coupons == null) {
            return List.of();
        }
        return coupons.stream().map(mapper::toDto).toList();
    }
}
