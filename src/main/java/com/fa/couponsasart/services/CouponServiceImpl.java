package com.fa.couponsasart.services;

import com.fa.couponsasart.configurations.PaginationConstants;
import com.fa.couponsasart.controllers.exceptions.NotFoundException;
import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.entities.Coupon;
import com.fa.couponsasart.domain.mappers.CouponMapper;
import com.fa.couponsasart.repositories.CouponsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@Primary
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponsRepository couponsRepo;
    private final CouponMapper mapper;

    @Override
    public Page<CouponDTO> getAll(Optional<List<String>> category, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice, Optional<Integer> pageNumber, Optional<Integer> pageSize) {
        if (category.isPresent() || minPrice.isPresent() || maxPrice.isPresent()) {
            return findAllWithParams(category, minPrice, maxPrice, pageNumber, pageSize);
        }
        return findAll(pageNumber, pageSize);
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
    public void deleteById(BigInteger id, BigInteger... moreIds) {
        couponsRepo.deleteById(id);
        if (moreIds.length > 0) {
            List<BigInteger> ids = Arrays.asList(moreIds);
            ids.add(id);
            couponsRepo.deleteAllById(ids);
        } else {
            couponsRepo.deleteById(id);
        }
    }

    @Override
    public void updateById(BigInteger id, CouponDTO dto) throws NotFoundException {
        if (!couponsRepo.existsById(id)) {
            throw new NotFoundException("Coupon with id " + id + " not found");
        }

        Coupon toBeSaved = mapper.toEntity(dto);
        toBeSaved.setId(id);
        couponsRepo.save(toBeSaved);
    }

    @Override
    public void patchById(BigInteger id, CouponDTO dto) {
        Coupon found = findById(id);
        if (found == null) {
            return;
        }


        // TODO implement patch
    }

    @Override
    public <ID> Page<CouponDTO> findAllByUser(ID userId, Optional<Integer> pageNumber, Optional<Integer> pageSize, Optional<Predicate<CouponDTO>> filter) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
        Page<Coupon> page =  couponsRepo.findAllByUserId(userId, pageRequest);
        return page.map(mapper::toDto);
    }

    private Coupon findById(BigInteger id) {
        return couponsRepo.findById(id).orElse(null);
    }

    private Page<CouponDTO> findAll(Optional<Integer> pageNumber, Optional<Integer> pageSize) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
        Page<Coupon> page = couponsRepo.findAll(pageRequest);
        return page.map(mapper::toDto);
    }

    private Page<CouponDTO> findAllWithParams(Optional<List<String>> category, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice, Optional<Integer> pageNumber, Optional<Integer> pageSize) {
        // TODO implement
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
        Page<Coupon> page = couponsRepo.findAll(pageRequest);
        return null;
    }

    private PageRequest buildPageRequest(Optional<Integer> pageNumber, Optional<Integer> pageSize) {
        int page = pageNumber.orElse(PaginationConstants.Defaults.FIRST_PAGE);
        int size = pageSize.filter(val -> val < PaginationConstants.MAX_PAGE_SIZE).orElse(PaginationConstants.Defaults.PAGE_SIZE);

        return PageRequest.of(page == 0 ? page : page - 1, size, PaginationConstants.Defaults.ID_DESC_SORT);
    }

}
