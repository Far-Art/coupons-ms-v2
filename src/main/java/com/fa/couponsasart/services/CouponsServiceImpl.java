package com.fa.couponsasart.services;

import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.entities.Coupon;
import com.fa.couponsasart.domain.mappers.CouponMapper;
import com.fa.couponsasart.repositories.CouponsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class CouponsServiceImpl implements CouponsService {

    private final CouponsRepository couponsRepo;
    private final CouponMapper mapper;

    @Override
    public List<CouponDTO> getAll() {
        return couponsRepo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<CouponDTO> getById(String id) {
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
    public boolean deleteById(String id) {
        couponsRepo.deleteById(id);
        return !couponsRepo.existsById(id);
    }

    @Override
    public boolean updateById(String id, CouponDTO dto) {
        if (!couponsRepo.existsById(id)) {
            return false;
        }

        Coupon toBeSaved = mapper.toEntity(dto);
        toBeSaved.setId(id);
        couponsRepo.save(toBeSaved);
        return true;
    }

    @Override
    public boolean patchById(String id, CouponDTO dto) {
        Coupon found = findById(id);
        if (found == null) {
            return false;
        }


        // TODO implement patch
        return true;
    }

    private Coupon findById(String id) {
        return couponsRepo.findById(id).orElse(null);
    }
}
